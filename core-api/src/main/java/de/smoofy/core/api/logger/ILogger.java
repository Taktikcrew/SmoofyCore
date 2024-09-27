package de.smoofy.core.api.logger;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 27.09.24, 23:18
 */

import de.smoofy.core.api.logger.enumeration.LogType;

public interface ILogger {

    /**
     * Logs a message with the given log type.
     *
     * @param logType the type of the log
     * @param message the log message
     */
    void log(LogType logType, String message);

    /**
     * Jump to the next line.
     */
    void newLine();
}
