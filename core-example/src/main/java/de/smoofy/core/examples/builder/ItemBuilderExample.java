package de.smoofy.core.examples.builder;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 11:39
 */

import de.smoofy.core.api.builder.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class ItemBuilderExample {

    public void test(Player player) {
        player.getInventory().addItem(ItemBuilder.of(Material.DIAMOND_AXE)
                .name(Component.text("Test Item"))
                .lore(Component.text("Test Lore"))
                .amount(2)
                .unbreakable()
                .enchantUnsafe(10, Enchantment.SHARPNESS)
                .build());
    }

}
