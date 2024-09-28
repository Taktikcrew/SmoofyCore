package de.smoofy.core.base.logger;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 00:02
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.api.logger.ILogger;
import de.smoofy.core.api.logger.enumeration.ConsoleColor;
import de.smoofy.core.api.logger.enumeration.LogType;
import de.smoofy.core.base.bootstrap.PaperBootstrap;
import de.smoofy.core.base.bootstrap.VelocityBootstrap;

public class LoggerImpl implements ILogger {

    @Override
    public void log(LogType logType, String message) {
        if (Core.instance().isPaper()) {
            PaperBootstrap.instance().getLogger().info(ConsoleColor.GRAY + "[" + logType.consoleColor() +
                    logType.label() + ConsoleColor.GRAY + "] » " + logType.consoleColor() + message);
            return;
        }
        VelocityBootstrap.instance().logger().info(ConsoleColor.GRAY + "[" + logType.consoleColor() +
                logType.label() + ConsoleColor.GRAY + "] » " + logType.consoleColor() + message);
    }

    @Override
    public void newLine() {
        if (Core.instance().isPaper()) {
            PaperBootstrap.instance().getLogger().info(" ");
            return;
        }
        VelocityBootstrap.instance().logger().info(" ");
    }
}
