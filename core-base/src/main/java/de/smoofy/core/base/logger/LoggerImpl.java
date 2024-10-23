/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.logger;

import de.smoofy.core.api.logger.ILogger;
import de.smoofy.core.api.logger.enumeration.ConsoleColor;
import de.smoofy.core.api.logger.enumeration.LogType;
import de.smoofy.core.base.bootstrap.VelocityBootstrap;
import org.bukkit.plugin.java.JavaPlugin;

public class LoggerImpl implements ILogger {

    private final JavaPlugin plugin;

    public LoggerImpl(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void log(LogType logType, String message) {
        if (this.plugin != null) {
            this.plugin.getLogger().info(ConsoleColor.GRAY.code() + "[" + logType.consoleColor().code() +
                    logType.label() + ConsoleColor.GRAY.code() + "] » " + logType.consoleColor().code() + message);
            return;
        }
        VelocityBootstrap.instance().logger().info(ConsoleColor.GRAY.code() + "[" + logType.consoleColor().code() +
                logType.label() + ConsoleColor.GRAY.code() + "] » " + logType.consoleColor() + message);
    }

    @Override
    public void newLine() {
        if (this.plugin != null) {
            this.plugin.getLogger().info(" ");
            return;
        }
        VelocityBootstrap.instance().logger().info(" ");
    }
}
