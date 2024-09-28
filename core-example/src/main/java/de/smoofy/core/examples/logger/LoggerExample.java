package de.smoofy.core.examples.logger;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 11:41
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.api.logger.enumeration.LogType;

public class LoggerExample {

    public void test() {
        Core.instance().logger().log(LogType.INFO, "This is a info log message.");
        Core.instance().logger().newLine();
        Core.instance().logger().log(LogType.ERROR, "This is a error log message.");
        Core.instance().logger().log(LogType.WARNING, "This is a warning log message.");
        Core.instance().logger().log(LogType.DEBUG, "This is a debug log message.");
    }

}
