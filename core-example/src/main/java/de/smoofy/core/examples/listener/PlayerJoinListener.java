package de.smoofy.core.examples.listener;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 29.09.24, 22:47
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.examples.event.CorePlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        var player = Core.instance().corePlayerProvider().corePlayer(event.getPlayer());
        Bukkit.getPluginManager().callEvent(new CorePlayerJoinEvent(player));
    }

}
