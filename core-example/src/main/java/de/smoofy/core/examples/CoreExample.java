package de.smoofy.core.examples;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 11:42
 */

import de.smoofy.core.examples.commands.TestCommand;
import de.smoofy.core.examples.listener.CorePlayerJoinListener;
import de.smoofy.core.examples.listener.PlayerJoinListener;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreExample extends JavaPlugin {

    @Getter
    @Accessors(fluent = true)
    private static CoreExample instance;

    @Override
    public void onEnable() {
        instance = this;

        new TestCommand();

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new CorePlayerJoinListener(), this);
    }
}
