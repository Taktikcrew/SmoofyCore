/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.paper.modules.hologram;

import com.google.common.collect.Lists;
import de.smoofy.core.api.module.hologram.IHologram;
import de.smoofy.core.api.module.hologram.IHologramProvider;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;

import java.util.Collections;
import java.util.List;

public class HologramProviderImpl implements IHologramProvider {

    private final List<IHologram> holograms;

    public HologramProviderImpl() {
        this.holograms = Lists.newArrayList();
    }

    @Override
    public IHologram create(String key, Component text, Location location) {
        return new HologramImpl(key, Collections.singletonList(text), location);
    }

    @Override
    public IHologram create(String key, List<Component> text, Location location) {
        return new HologramImpl(key, text, location);
    }

    @Override
    public IHologram hologram(String key) {
        return this.holograms.stream().filter(hologram -> hologram.key().equals(key)).findFirst().orElse(null);
    }

    @Override
    public void cache(IHologram hologram) {
        this.holograms.add(hologram);
    }

    @Override
    public List<IHologram> holograms() {
        return this.holograms;
    }
}
