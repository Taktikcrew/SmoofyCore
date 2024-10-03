package de.smoofy.core.api.module.hologram;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 16:05
 */

import de.smoofy.core.api.player.ICorePlayer;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;

import java.util.List;

public interface IHologram {

    /**
     * Get the key of the hologram.
     *
     * @return the key of the hologram
     */
    String key();

    /**
     * Get the text of the hologram.
     *
     * @return the text of the hologram
     */
    List<Component> text();

    /**
     * Spawn the hologram for a player.
     *
     * @param player the player
     */
    void spawn(ICorePlayer player);

    /**
     * Destroy the hologram for a player.
     *
     * @param player the player
     */
    void destroy(ICorePlayer player);

    /**
     * Get the location of the hologram.
     *
     * @return the location of the hologram
     */
    Location location();

}
