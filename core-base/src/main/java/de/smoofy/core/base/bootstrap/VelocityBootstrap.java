package de.smoofy.core.base.bootstrap;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 27.09.24, 23:46
 */

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import de.smoofy.core.base.CoreBase;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@Plugin(id = "SmoofyCore", name = "SmoofyCore", version = "1.0-SNAPSHOT", authors = {"Smoofy"})
public class VelocityBootstrap {

    @Getter
    @Accessors(fluent = true)
    private static VelocityBootstrap instance;

    private final ProxyServer proxyServer;

    @Inject
    public VelocityBootstrap(ProxyServer proxyServer) {
        this.proxyServer = proxyServer;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        instance = this;

        new CoreBase(false);
    }
}
