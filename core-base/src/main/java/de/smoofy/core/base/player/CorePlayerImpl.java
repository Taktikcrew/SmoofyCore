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
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.UUID;

// TODO: Implement all methods
public class CorePlayerImpl implements ICorePlayer {

    private final UUID uniqueId;
    private final String name;

    private BukkitTask actionBarTask;

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
        this.message(MiniMessage.miniMessage().deserialize("<dark_gray>[<aqua>Core<dark_gray>] <white>").append(message));
    }

    @Override
    public void usage(String usage) {
        this.message(MiniMessage.miniMessage().deserialize("<dark_gray>[<aqua>Core<dark_gray>] ")
                .append(Component.translatable("message.usage"))
                .append(Component.text(" ", NamedTextColor.DARK_GRAY))
                .append(Component.text(usage, NamedTextColor.AQUA)));
    }

    @Override
    public void usage(Component prefix, String usage) {
        this.message(Component.text("[", NamedTextColor.DARK_GRAY)
                .append(prefix)
                .append(Component.text("] ", NamedTextColor.DARK_GRAY))
                .append(Component.translatable("message.usage"))
                .append(Component.text(" ", NamedTextColor.DARK_GRAY))
                .append(Component.text(usage, prefix.color())));
    }

    @Override
    public void noPerms() {
        this.message(Component.text("Unknown command. Type \"/help\" for help."));
    }

    @Override
    public void notOnline(String target) {
        var targetPlayer = Core.instance().corePlayerProvider().corePlayer(target);
        if (targetPlayer == null) {
            this.pMessage(Component.translatable("message.player-not-found", Component.text(target)));
        } else {
            this.pMessage(Component.translatable("message.player-not-online", targetPlayer.displayName()));
        }
    }

    @Override
    public void sendActionBar(Component message) {
        if (this.bukkitPlayer() == null) {
            this.actionBarTask.cancel();
            return;
        }
        this.bukkitPlayer().sendActionBar(message);
    }

    @Override
    public void sendActionBarPermanent(Component message) {
        this.actionBarTask = Core.instance().coreTask().repeatAsync(() -> this.sendActionBar(message), 0, 20);
    }

    @Override
    public void setTablist(boolean ingame) {
        throw new NotImplementedException("Not implemented yet.");
    }

    @Override
    public void sendTitle(@NotNull Component title, @NotNull Component subtitle, int fadeIn, int stay, int fadeOut) {
        if (fadeIn == -1) {
            fadeIn = 1;
        }
        if (stay == -1) {
            stay = 3;
        }
        if (fadeOut == -1) {
            fadeOut = 1;
        }
        this.bukkitPlayer().showTitle(Title.title(title, subtitle, Title.Times.times(Duration.ofSeconds(fadeIn),
                Duration.ofSeconds(stay), Duration.ofSeconds(fadeOut))));
    }

    @Override
    public void resetTitle() {
        this.bukkitPlayer().resetTitle();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ICorePlayer player)) {
            return false;
        }
        return this.uuid().equals(player.uuid()) && this.name.equals(player.name());
    }
}
