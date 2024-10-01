package de.smoofy.core.examples.listener;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 29.09.24, 22:48
 */

import de.smoofy.core.examples.event.CorePlayerJoinEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CorePlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(CorePlayerJoinEvent event) {
        event.player().message(Component.text("Welcome to the server!"));
    }

}
