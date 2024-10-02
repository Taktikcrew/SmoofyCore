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

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LocalizeImpl implements ILocalize {

    private final Class<?> clazz;

    private final Map<Language, Properties> languageProperties = Maps.newHashMap();

    public LocalizeImpl(Class<?> clazz) {
        this.clazz = clazz;
    }

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
        return MessageFormat.format(message, replacements);
    }

    @SneakyThrows
    private void cacheLanguageMessages(Language language) {
        var codeSource = this.clazz.getProtectionDomain().getCodeSource();
        var jar = codeSource.getLocation();
        var zipInputStream = new ZipInputStream(jar.openStream());
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
           var entry = zipEntry.getName();
           if (entry.contains(language.fileName())) {
               var properties = new Properties();
               properties.load(zipInputStream);
               this.languageProperties.put(language, properties);
               zipInputStream.close();
               break;
           }
        }
    }
}
