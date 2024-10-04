package de.smoofy.core.base.localize;

import lombok.AllArgsConstructor;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.ParsingException;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@AllArgsConstructor
public class CoreTranslationRegistry implements TranslationRegistry {

    private final TranslationRegistry translationRegistry;

    @Override
    public boolean contains(@NotNull String key) {
        return this.translationRegistry.contains(key);
    }

    @Override
    public @NotNull Key name() {
        return this.translationRegistry.name();
    }

    @Override
    public @Nullable MessageFormat translate(@NotNull String key, @NotNull Locale locale) {
        return this.translationRegistry.translate(key, locale);
    }

    @Override
    public @Nullable Component translate(@NotNull TranslatableComponent component, @NotNull Locale locale) {
        var messageFormat = this.translationRegistry.translate(component.key(), locale);
        if (messageFormat == null) {
            return null;
        }

        var message = messageFormat.toPattern();

        Component translatedComponent;
        if (component.arguments().isEmpty()) {
            translatedComponent = MiniMessage.miniMessage().deserialize(message);
        } else {
            for (int i = 0; i < component.arguments().size(); i++) {
                message = message.replace("{" + i + "}", "<arg:" + i + ">");
            }
            translatedComponent = MiniMessage.miniMessage().deserialize(message, new ArgumentTag(component.arguments()));
        }

        if (component.children().isEmpty()) {
            return translatedComponent;
        }

        return translatedComponent.children(component.children());
    }

    @Override
    public void defaultLocale(@NotNull Locale locale) {
        this.translationRegistry.defaultLocale(locale);
    }

    @Override
    public void register(@NotNull String key, @NotNull Locale locale, @NotNull MessageFormat format) {
        this.translationRegistry.register(key, locale, format);
    }

    @Override
    public void unregister(@NotNull String key) {
        this.translationRegistry.unregister(key);
    }

    private record ArgumentTag(List<? extends ComponentLike> argumentComponents) implements TagResolver {

        private static final String NAME = "arg";

        private ArgumentTag(List<? extends ComponentLike> argumentComponents) {
            this.argumentComponents = Objects.requireNonNull(argumentComponents, "argumentComponents");
        }

        @Override
        public @NotNull Tag resolve(@NotNull String name, @NotNull ArgumentQueue arguments, @NotNull Context context) throws ParsingException {
            var index = arguments.popOr("No argument number provided")
                    .asInt().orElseThrow(() -> context.newException("Invalid argument number", arguments));

            if (index < 0 || index >= this.argumentComponents.size()) {
                throw context.newException("Invalid argument number", arguments);
            }
            return Tag.inserting(argumentComponents.get(index));
        }

        @Override
        public boolean has(@NotNull String name) {
            return name.equals(NAME);
        }
    }
}
