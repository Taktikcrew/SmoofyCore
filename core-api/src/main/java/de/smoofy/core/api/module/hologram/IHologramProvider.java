package de.smoofy.core.api.module.hologram;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 16:05
 */

import de.smoofy.core.api.annotation.DoNotUse;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;

import java.util.List;

public interface IHologramProvider {

    /**
     * Create a new hologram.
     *
     * @param key      the key of the hologram
     * @param text     the text of the hologram
     * @param location the location of the hologram
     * @return the created {@link IHologram}
     */
    IHologram create(String key, Component text, Location location);

    /**
     * Create new holograms.
     *
     * @param key      the key of the hologram
     * @param text     the text of the holograms
     * @param location the location of the holograms
     * @return a list of the created {@link IHologram}s
     */
    IHologram create(String key, List<Component> text, Location location);

    /**
     * Get a hologram by its key.
     *
     * @param key the key of the hologram
     * @return the {@link IHologram} or null if not found
     */
    IHologram hologram(String key);

    /**
     * Cache a hologram.
     *
     * @param hologram the hologram to cache
     */
    @DoNotUse void cache(IHologram hologram);

    /**
     * Get all cached holograms.
     *
     * @return a list of all cached holograms
     */
    List<IHologram> holograms();

}
