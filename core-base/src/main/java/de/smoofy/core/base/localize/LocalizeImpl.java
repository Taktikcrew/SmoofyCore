package de.smoofy.core.base.localize;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 00:35
 */

import com.google.common.collect.Maps;
import de.smoofy.core.api.localization.ILocalize;
import de.smoofy.core.api.localization.Language;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class LocalizeImpl implements ILocalize {

    private final Map<Language, Properties> languageProperties = Maps.newHashMap();

    @Override
    public void loadLanguages(Language... languages) {
        Arrays.stream(languages).forEach(this::cacheLanguageMessages);
    }

    @Override
    public String translate(Language language, String key, Object... replacements) {
        var properties = this.languageProperties.get(language);
        var message = properties.getProperty(key);
        if (message == null) {
            return key;
        }
        return String.format(message, replacements);
    }

    @SneakyThrows
    private void cacheLanguageMessages(Language language) {
        var fileInputStream = new FileInputStream("src/main/resources/language/" + language.fileName());
        var properties = new Properties();
        properties.load(fileInputStream);
        this.languageProperties.put(language, properties);
        fileInputStream.close();
    }
}
