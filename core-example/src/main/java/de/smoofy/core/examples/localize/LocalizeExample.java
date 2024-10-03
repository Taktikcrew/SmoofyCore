package de.smoofy.core.examples.localize;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 11:51
 */

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class LocalizeExample {

    public void test(Player player) {
        player.sendMessage(Component.translatable("test.localization", Component.text("Das ist das Replacement!")));
    }

}
