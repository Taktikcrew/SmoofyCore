/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples;

import de.smoofy.core.api.Core;
import de.smoofy.core.examples.commands.TestCommand;
import de.smoofy.core.examples.game.countdown.CountdownTickListener;
import de.smoofy.core.examples.listener.CorePlayerJoinListener;
import de.smoofy.core.examples.listener.PlayerJoinListener;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;

public class CoreExample extends JavaPlugin {

    @Getter
    @Accessors(fluent = true)
    private static CoreExample instance;

    @Override
    public void onEnable() {
        instance = this;

        Core.instance().localize().init(this.getClass(), "Example", Locale.GERMANY, Locale.US);

        new TestCommand();

        Bukkit.getPluginManager().registerEvents(new CountdownTickListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new CorePlayerJoinListener(), this);
    }
}
