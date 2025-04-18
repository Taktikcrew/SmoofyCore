/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.game.phase;

import de.smoofy.core.api.game.phase.Phase;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;

public class LobbyPhase extends Phase {

    public LobbyPhase() {
        super("Lobby");
    }

    @Override
    public void onEnable() {
        Bukkit.broadcast(Component.text("Lobby Phase enabled"));
    }

    @Override
    public void onDisable() {
        Bukkit.broadcast(Component.text("Lobby Phase disabled"));
    }
}
