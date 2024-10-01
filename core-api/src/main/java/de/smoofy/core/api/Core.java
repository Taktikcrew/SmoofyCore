package de.smoofy.core.api;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 27.09.24, 22:41
 */

import de.smoofy.core.api.fetcher.IUUIDFetcher;
import de.smoofy.core.api.localization.ILocalize;
import de.smoofy.core.api.logger.ILogger;
import de.smoofy.core.api.message.IMessageBuilder;
import de.smoofy.core.api.player.ICorePlayerProvider;
import de.smoofy.core.api.time.ITimeHandler;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Core {

    @Getter
    @Accessors(fluent = true)
    private static Core instance;

    /**
     * Set the instance of the core.
     *
     * @param instance the Core instance
     */
    protected static void instance(@NotNull Core instance) {
        Core.instance = instance;
    }

    /**
     * Check if the server is running on paper.
     *
     * @return true if the server is running on paper, false otherwise
     */
    public abstract boolean isPaper();

    /**
     * Get the UUID fetcher.
     *
     * @return the {@link IUUIDFetcher}
     */
    public abstract IUUIDFetcher uuidFetcher();

    /**
     * Get the localization.
     *
     * @return the {@link ILocalize}
     */
    public abstract ILocalize localize();

    /**
     * Get the logger.
     *
     * @param plugin the plugin
     * @return the {@link ILogger}
     */
    public abstract ILogger logger(@Nullable JavaPlugin plugin);

    /**
     * Get the message builder.
     *
     * @param text the text
     * @return the {@link IMessageBuilder}
     */
    public abstract IMessageBuilder messageBuilder(String text);

    /**
     * Get the core player provider.
     *
     * @return the {@link ICorePlayerProvider}
     */
    public abstract ICorePlayerProvider corePlayerProvider();

    /**
     * Get the time handler.
     *
     * @return the {@link ITimeHandler}
     */
    public abstract ITimeHandler timeHandler();

}
