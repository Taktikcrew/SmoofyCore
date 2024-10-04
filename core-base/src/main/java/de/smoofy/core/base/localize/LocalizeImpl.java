package de.smoofy.core.base.localize;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 00:35
 */

import de.smoofy.core.api.localization.ILocalize;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import net.kyori.adventure.util.UTF8ResourceBundleControl;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizeImpl implements ILocalize {

    @Override
    public void init(Class<?> clazz, String baseName, Locale... locales) {
        var translationRegistry = new CoreTranslationRegistry(TranslationRegistry.create(Key.key("smoofycore:messages")));
        for (var locale : locales) {
            var resourceBundle = ResourceBundle.getBundle("language." + baseName, locale,
                    clazz.getClassLoader(), UTF8ResourceBundleControl.get());
            translationRegistry.registerAll(locale, resourceBundle, false);
        }
        GlobalTranslator.translator().addSource(translationRegistry);
    }
}
