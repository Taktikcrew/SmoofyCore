/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.paper.listener;

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