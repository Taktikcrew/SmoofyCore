/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;

public interface IMessageBuilder {

    /**
     * Add a hover message to the Component.
     *
     * @param hover the hover message
     * @return the MessageBuilder
     */
    IMessageBuilder hover(Component hover);

    /**
     * Add a click action to the Component.
     *
     * @param action the click action {@link ClickEvent.Action}
     * @param click  the execution of the click
     * @return the MessageBuilder
     */
    IMessageBuilder click(ClickEvent.Action action, String click);

    /**
     * Build the Component.
     *
     * @return the built Component
     */
    Component build();

}
