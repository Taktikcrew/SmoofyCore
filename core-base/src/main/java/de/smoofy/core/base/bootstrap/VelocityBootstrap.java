/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.bootstrap;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import de.smoofy.core.base.CoreBase;
import de.smoofy.core.base.velocity.listener.DisconnectListener;
import de.smoofy.core.base.velocity.listener.PostLoginListener;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.slf4j.Logger;

@Getter
@Accessors(fluent = true)
@Plugin(id = "SmoofyCore", name = "SmoofyCore", version = "1.0-SNAPSHOT", authors = {"Smoofy"})
public class VelocityBootstrap {

    @Getter
    @Accessors(fluent = true)
    private static VelocityBootstrap instance;

    private final ProxyServer proxyServer;
    private final Logger logger;

    @Inject
    public VelocityBootstrap(ProxyServer proxyServer, Logger logger) {
        this.proxyServer = proxyServer;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        instance = this;

        new CoreBase(false);

        this.registerListener();
    }

    private void registerListener() {
        this.proxyServer.getEventManager().register(this, new DisconnectListener());
        this.proxyServer.getEventManager().register(this, new PostLoginListener());
    }
}
