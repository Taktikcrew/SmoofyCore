/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api;

import de.smoofy.core.api.config.IConfig;
import de.smoofy.core.api.fetcher.IUUIDFetcher;
import de.smoofy.core.api.game.IGameConfiguration;
import de.smoofy.core.api.game.countdown.ICountdownProvider;
import de.smoofy.core.api.game.phase.IPhaseHandler;
import de.smoofy.core.api.localization.ILocalize;
import de.smoofy.core.api.logger.ILogger;
import de.smoofy.core.api.message.IMessageBuilder;
import de.smoofy.core.api.module.hologram.IHologramProvider;
import de.smoofy.core.api.module.tasks.ICoreTask;
import de.smoofy.core.api.player.ICorePlayerProvider;
import de.smoofy.core.api.time.ITimeHandler;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

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
     * Get the config.
     *
     * @param directory the directory
     * @param fileName the file name
     * @return the {@link IConfig}
     */
    public abstract IConfig config(File directory, String fileName);

    /**
     * Get the UUID fetcher.
     *
     * @return the {@link IUUIDFetcher}
     */
    public abstract IUUIDFetcher uuidFetcher();

    /**
     * Get the countdown provider.
     *
     * @return the {@link ICountdownProvider}
     */
    public abstract ICountdownProvider countdownProvider();

    /**
     * Get the phase handler.
     *
     * @return the {@link IPhaseHandler}
     */
    public abstract IPhaseHandler phaseHandler();

    /**
     * Create the game configuration.
     *
     * @param minPlayers the amount of minimum players
     * @param maxPlayers the amount of maximum players
     * @param teams the amount of teams
     * @param teamSize the amount of players per team
     * @return the created {@link IGameConfiguration}
     */
    public abstract IGameConfiguration gameConfiguration(int minPlayers, int maxPlayers, int teams, int teamSize);

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
     * Get the hologram provider.
     *
     * @return the {@link IHologramProvider}
     */
    public abstract IHologramProvider hologramProvider();

    /**
     * Get the core task.
     *
     * @return the {@link ICoreTask}
     */
    public abstract ICoreTask coreTask();

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
