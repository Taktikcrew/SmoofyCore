package de.smoofy.core.api.localization;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 00:32
 */

import java.util.Locale;

public interface ILocalize {

    /**
     * Initializes the localization.
     *
     * @param clazz the plugin class
     * @param baseName the base name of the properties file
     * @param locales the locales to load
     */
    void init(Class<?> clazz, String baseName, Locale... locales);

}
