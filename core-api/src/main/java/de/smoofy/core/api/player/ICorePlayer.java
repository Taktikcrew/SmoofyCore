package de.smoofy.core.api.player;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 11:44
 */

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface ICorePlayer {

    /**
     * Get the name of the player.
     *
     * @return the player's name
     */
    String name();

    /**
     * Get the UUID of the player.
     *
     * @return the player's UUID
     */
    UUID uuid();

    /**
     * Get the display name of the player.
     *
     * @return the player's display name
     */
    String displayName();

    /**
     * Get the color of the player.
     *
     * @return the player's color
     */
    NamedTextColor color();

    /**
     * Get the bukkit player.
     *
     * @return {@link Player}
     */
    Player bukkitPlayer();

    /**
     * Get the velocity player.
     *
     * @return {@link com.velocitypowered.api.proxy.Player}
     */
    com.velocitypowered.api.proxy.Player velocityPlayer();

    /**
     * Check if the player is online.
     *
     * @return true if the player is online, otherwise false
     */
    boolean isOnline();

    /**
     * Get the coins of the player.
     *
     * @return the player's coins
     */
    int coins();

    /**
     * Get the online time of the player.
     *
     * @return the player's online time
     */
    int onlineTime();

    /**
     * Send a message to the player.
     *
     * @param message the message
     */
    void message(Component message);

    /**
     * Send a message with 'Core' prefix to the player.
     *
     * @param message the message
     */
    void pMessage(Component message);

    /**
     * Send the usage message to the player.
     *
     * @param usage the usage
     */
    void usage(String usage);

    /**
     * Send the usage message with prefix to the player.
     *
     * @param prefix the prefix
     * @param usage the usage
     */
    void usage(Component prefix, String usage);

    /**
     * Send the no permission message to the player.
     */
    void noPerms();

    /**
     * Send the not online message to the player.
     *
     * @param target the target
     */
    void notOnline(ICorePlayer target);

}
