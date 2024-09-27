package de.smoofy.core.api.localization;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 00:32
 */

public interface ILocalize {

    void loadLanguages(Language... languages);

    String translate(Language language, String key, Object... replacements);

}
