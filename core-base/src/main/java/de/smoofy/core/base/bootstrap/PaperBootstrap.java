package de.smoofy.core.base.bootstrap;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 27.09.24, 23:46
 */

import com.github.retrooper.packetevents.PacketEvents;
import de.smoofy.core.base.CoreBase;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import lombok.Getter;
import lombok.experimental.Accessors;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.spigot.SpigotEntityLibPlatform;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Accessors(fluent = true)
public class PaperBootstrap extends JavaPlugin {

    @Getter
    @Accessors(fluent = true)
    private static PaperBootstrap instance;

    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {
        instance = this;

        PacketEvents.getAPI().init();
        EntityLib.init(new SpigotEntityLibPlatform(this), new APIConfig(PacketEvents.getAPI()));

        new CoreBase(true);
    }

    @Override
    public void onDisable() {
        instance = null;

        PacketEvents.getAPI().terminate();
    }
}
