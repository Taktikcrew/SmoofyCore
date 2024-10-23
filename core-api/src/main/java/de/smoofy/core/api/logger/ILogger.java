/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.logger;

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
