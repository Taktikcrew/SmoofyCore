/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.fetcher;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface IUUIDFetcher {

    /**
     * Get a player's UUID from their name.
     *
     * @param name The name of the player
     * @return The UUID of the player
     */
    UUID uuid(@NotNull String name);

    /**
     * Get a player's name from their UUID.
     *
     * @param uuid The UUID of the player
     * @return The name of the player
     */
    String name(@NotNull UUID uuid);

}
