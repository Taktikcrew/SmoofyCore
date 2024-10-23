/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.logger;

import de.smoofy.core.api.Core;
import de.smoofy.core.api.logger.ILogger;
import de.smoofy.core.api.logger.enumeration.LogType;
import de.smoofy.core.examples.CoreExample;

public class LoggerExample {

    private final ILogger logger = Core.instance().logger(CoreExample.instance());

    public void test() {
        this.logger.log(LogType.INFO, "This is a info log message.");
        this.logger.newLine();
        this.logger.log(LogType.ERROR, "This is a error log message.");
        this.logger.log(LogType.WARNING, "This is a warning log message.");
        this.logger.log(LogType.DEBUG, "This is a debug log message.");
    }

}
