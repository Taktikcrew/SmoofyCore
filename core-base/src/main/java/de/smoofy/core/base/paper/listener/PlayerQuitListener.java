package de.smoofy.core.base.paper.listener;
/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 04.10.24, 16:02
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.base.bootstrap.PaperBootstrap;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    public PlayerQuitListener() {
        Bukkit.getPluginManager().registerEvents(this, PaperBootstrap.instance());
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.quitMessage(null);

        var player = Core.instance().corePlayerProvider().corePlayer(event.getPlayer());
        Core.instance().corePlayerProvider().update(player);
    }
}