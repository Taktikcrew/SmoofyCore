/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.player;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface ICorePlayerProvider {

    /**
     * Get the core player of the player.
     *
     * @param player the paper player
     * @return the {@link ICorePlayer} of the player
     */
    ICorePlayer corePlayer(Player player);

    /**
     * Get the core player of the uuid.
     *
     * @param uuid the uuid of the player
     * @return the {@link ICorePlayer} of the uuid
     */
    ICorePlayer corePlayer(UUID uuid);

    /**
     * Get the core player of the name.
     *
     * @param name the name of the player
     * @return the {@link ICorePlayer} of the name
     */
    ICorePlayer corePlayer(String name);

    /**
     * Get all core players.
     *
     * @return a list of all core players
     */
    List<ICorePlayer> corePlayers();

    /**
     * Initialize the core player.
     *
     * @param uuid the uuid of the player
     */
    void init(UUID uuid);

    /**
     * Update the core player.
     *
     * @param player the core player
     */
    void update(ICorePlayer player);

    /**
     * Check if the core player exists.
     *
     * @param uuid the uuid of the player
     * @return true if the core player exists, otherwise false
     */
    boolean exists(UUID uuid);

}
