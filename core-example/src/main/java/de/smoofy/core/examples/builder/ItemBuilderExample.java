/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.builder;

import de.smoofy.core.api.builder.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemBuilderExample {

    public void test(Player player) {
        player.getInventory().addItem(ItemBuilder.of(Material.DIAMOND_AXE)
                .name(Component.text("Test Item"))
                .lore(Component.text("Test Lore"))
                .event("Axt", PlayerInteractEvent.class, event -> event.getPlayer().sendMessage("Interacted with the item!"))
                .amount(2)
                .unbreakable()
                .enchantUnsafe(10, Enchantment.SHARPNESS)
                .build());
        player.getInventory().addItem(ItemBuilder.of(Material.STONE_SWORD)
                .event("Stone Sword", PlayerInteractEvent.class, event -> event.getPlayer().sendMessage("Clicked stone sword!"))
                .build());
    }

}
