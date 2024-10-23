/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.message;

import de.smoofy.core.api.message.IMessageBuilder;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;

@RequiredArgsConstructor
public class MessageBuilderImpl implements IMessageBuilder {

    private final String text;

    private Component hover;

    private ClickEvent.Action action;
    private String click;

    @Override
    public IMessageBuilder hover(Component hover) {
        this.hover = hover;
        return this;
    }

    @Override
    public IMessageBuilder click(ClickEvent.Action action, String click) {
        this.action = action;
        this.click = click;
        return this;
    }

    @Override
    public Component build() {
        var builder = Component.text(this.text).toBuilder();
        if (this.hover != null) {
            builder.hoverEvent(HoverEvent.showText(this.hover));
        }
        if (this.action != null && this.click != null) {
            builder.clickEvent(ClickEvent.clickEvent(this.action, this.click));
        }
        return builder.build();
    }
}
