package de.smoofy.core.api.localization;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 00:32
 */

public interface ILocalize {

    /**
     * Load all messages from the given languages.
     *
     * @param languages the languages to load
     */
    void loadLanguages(Language... languages);

    /**
     * Translate a message from the given language.
     *
     * @param language the language to translate the message to
     * @param key the key of the message
     * @param replacements the replacements for the message
     * @return the translated message
     */
    String translate(Language language, String key, Object... replacements);

}
