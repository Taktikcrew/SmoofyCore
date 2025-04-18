/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.game.countdown;

import de.smoofy.core.api.game.countdown.events.CountdownTickEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CountdownTickListener implements Listener {

    @EventHandler
    public void onTick(CountdownTickEvent event) {
        var countdown = event.countdown();
        Bukkit.broadcast(Component.text("Countdown: " + countdown.key() + " | Time: " + countdown.time() +
                " | CountType: " + countdown.countType()));
    }

}
