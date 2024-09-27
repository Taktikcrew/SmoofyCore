package de.smoofy.core.api.logger.enumeration;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 27.09.24, 23:20
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public enum LogType {

    SUCCESSFULLY(ConsoleColor.GREEN, "Successfully"),
    INFO(ConsoleColor.YELLOW, "Info"),
    ERROR(ConsoleColor.RED, "Error"),
    WARNING(ConsoleColor.ORANGE, "Warning"),
    DEBUG(ConsoleColor.BLUE, "Debug");

    private final ConsoleColor consoleColor;
    private final String label;
}
