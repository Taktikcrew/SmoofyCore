/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.localize;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class LocalizeExample {

    public void test(Player player) {
        player.sendMessage(Component.translatable("test.localization", Component.text("Das ist das Replacement!")));
    }

}
