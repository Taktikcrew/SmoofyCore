/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.game.countdown;

import de.smoofy.core.api.Core;
import de.smoofy.core.api.game.countdown.CountType;
import de.smoofy.core.api.game.countdown.ICountdown;

public class CountdownExample {

    private final ICountdown countdown;

    public CountdownExample() {
        this.countdown = Core.instance().countdownProvider().create("Test", CountType.INFINITY, 60);
    }

    public void test(String test) {
        switch (test.toLowerCase()) {
            case "start" -> countdown.start();
            case "stop" -> countdown.stop();
            case "infinity" -> countdown.countType(CountType.INFINITY);
            case "count" -> countdown.countType(CountType.COUNT);
            case "time" -> countdown.time(60);
        }
    }

}
