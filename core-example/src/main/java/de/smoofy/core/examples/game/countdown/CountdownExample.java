package de.smoofy.core.examples.game.countdown;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 13:55
 */

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
