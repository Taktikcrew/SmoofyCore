package de.smoofy.core.base.paper.listener;
/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 04.10.24, 17:14
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.base.bootstrap.PaperBootstrap;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class AsyncPlayerPreLoginListener implements Listener {

    public AsyncPlayerPreLoginListener() {
        Bukkit.getPluginManager().registerEvents(this, PaperBootstrap.instance());
    }

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent event) {
        Core.instance().corePlayerProvider().init(event.getUniqueId());
    }
}