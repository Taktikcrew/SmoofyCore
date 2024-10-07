package de.smoofy.core.examples.game.phase;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 14:08
 */

import de.smoofy.core.api.game.phase.Phase;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;

public class IngamePhase extends Phase {

    public IngamePhase() {
        super("Ingame");
    }

    @Override
    public void onEnable() {
        Bukkit.broadcast(Component.text("Ingame Phase enabled"));
    }

    @Override
    public void onDisable() {
        Bukkit.broadcast(Component.text("Ingame Phase disabled"));
    }
}
