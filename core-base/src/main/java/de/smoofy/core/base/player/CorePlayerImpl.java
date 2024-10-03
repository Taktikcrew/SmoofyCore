package de.smoofy.core.base.player;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 11:50
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.api.player.ICorePlayer;
import de.smoofy.core.base.bootstrap.VelocityBootstrap;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

// TODO: Implement all methods
public class CorePlayerImpl implements ICorePlayer {

    private final UUID uniqueId;
    private final String name;

    public CorePlayerImpl(Player player) {
        this.uniqueId = player.getUniqueId();
        this.name = player.getName();
    }

    public CorePlayerImpl(UUID uuid) {
        this.uniqueId = uuid;
        this.name = Core.instance().uuidFetcher().name(this.uniqueId);
    }

    public CorePlayerImpl(String name) {
        this.name = name;
        this.uniqueId = Core.instance().uuidFetcher().uuid(name);
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public UUID uuid() {
        return this.uniqueId;
    }

    @Override
    public String displayName() {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public NamedTextColor color() {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public Player bukkitPlayer() {
        return Bukkit.getPlayer(this.uuid());
    }

    @Override
    public com.velocitypowered.api.proxy.Player velocityPlayer() {
        return VelocityBootstrap.instance().proxyServer().getPlayer(this.uuid()).orElse(null);
    }

    @Override
    public boolean isOnline() {
        return this.velocityPlayer() != null;
    }

    @Override
    public int coins() {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public int onlineTime() {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public void message(Component message) {
        if (Core.instance().isPaper()) {
            this.bukkitPlayer().sendMessage(message);
        } else {
            this.velocityPlayer().sendMessage(message);
        }
    }

    @Override
    public void pMessage(Component message) {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public void usage(String usage) {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public void usage(Component prefix, String usage) {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public void noPerms() {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public void notOnline(ICorePlayer target) {
        throw new NotImplementedException("Not implemented yet.");
    }
}
