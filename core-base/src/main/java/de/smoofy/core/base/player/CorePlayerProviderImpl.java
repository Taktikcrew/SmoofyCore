package de.smoofy.core.base.player;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 11:51
 */

import com.google.common.collect.Maps;
import de.smoofy.core.api.Core;
import de.smoofy.core.api.player.ICorePlayer;
import de.smoofy.core.api.player.ICorePlayerProvider;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class CorePlayerProviderImpl implements ICorePlayerProvider {

    private final Map<Object, ICorePlayer> corePlayerCache = Maps.newHashMap();

    @Override
    public ICorePlayer corePlayer(Player player) {
        if (this.corePlayerCache.containsKey(player)) {
            return this.corePlayerCache.get(player);
        }
        var corePlayer = new CorePlayerImpl(player);
        this.cacheCorePlayer(corePlayer);
        return corePlayer;
    }

    @Override
    public ICorePlayer corePlayer(UUID uuid) {
        if (this.corePlayerCache.containsKey(uuid)) {
            return this.corePlayerCache.get(uuid);
        }
        var corePlayer = new CorePlayerImpl(uuid);
        this.cacheCorePlayer(corePlayer);
        return corePlayer;
    }

    @Override
    public ICorePlayer corePlayer(String name) {
        if (this.corePlayerCache.containsKey(name)) {
            return this.corePlayerCache.get(name);
        }
        var corePlayer = new CorePlayerImpl(name);
        this.cacheCorePlayer(corePlayer);
        return corePlayer;
    }

    @Override
    public void init(UUID uuid) {
        if (this.exists(uuid)) {
            return;
        }
        // TODO: Implement init method
    }

    @Override
    public boolean exists(UUID uuid) {
        return false;
    }

    private void cacheCorePlayer(ICorePlayer player) {
        this.corePlayerCache.put(player.uuid(), player);
        this.corePlayerCache.put(player.name(), player);
        if (!Core.instance().isPaper()) {
            return;
        }
        this.corePlayerCache.put(player.bukkitPlayer(), player);
    }
}
