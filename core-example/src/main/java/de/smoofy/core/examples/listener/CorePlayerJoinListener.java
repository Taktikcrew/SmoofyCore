/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.listener;

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
