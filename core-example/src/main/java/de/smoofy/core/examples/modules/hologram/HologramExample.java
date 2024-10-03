package de.smoofy.core.examples.modules.hologram;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 03.10.24, 11:47
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.api.player.ICorePlayer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.Arrays;

public class HologramExample {

    public void testSpawn(ICorePlayer player) {
        var hologram = Core.instance().hologramProvider().create("test", Arrays.asList(
                Component.text("Hallo", NamedTextColor.RED),
                Component.text("Welt", NamedTextColor.BLUE)
        ), player.bukkitPlayer().getLocation());
        hologram.spawn(player);
    }

    public void testDestroy(ICorePlayer player) {
        Core.instance().hologramProvider().hologram("test").destroy(player);
    }

}
