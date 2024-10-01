package de.smoofy.core.examples.message;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 11:42
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.api.message.IMessageBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.entity.Player;

public class MessageBuilderExample {

    private final IMessageBuilder messageBuilder = Core.instance().messageBuilder("Example Message");

    public void test(Player player) {
        player.sendMessage(messageBuilder
                .hover(Component.text("Hover Text"))
                .click(ClickEvent.Action.RUN_COMMAND, "/gamemode creative")
                .build());
    }

}
