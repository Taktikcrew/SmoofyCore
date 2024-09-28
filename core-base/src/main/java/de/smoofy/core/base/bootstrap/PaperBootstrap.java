package de.smoofy.core.base.bootstrap;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 27.09.24, 23:46
 */

import de.smoofy.core.base.CoreBase;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Accessors(fluent = true)
public class PaperBootstrap extends JavaPlugin {

    @Getter
    @Accessors(fluent = true)
    private static PaperBootstrap instance;


    @Override
    public void onEnable() {
        instance = this;

        new CoreBase(true);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
