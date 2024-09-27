package de.smoofy.core.api.localization;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 00:27
 */

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Language {

    GERMAN("de_DE"),
    ENGLISH("en_GB");

    private final String countryCode;

    public String fileName() {
        return this.countryCode + ".properties";
    }
}
