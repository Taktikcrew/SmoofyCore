/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.builder;

import de.smoofy.core.api.builder.InventoryBuilder;
import de.smoofy.core.api.builder.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class InventoryBuilderExample {

    public void test(Player player) {
        var inventory = InventoryBuilder.of(null, Component.text("Test Inventory"), 5);
        inventory.add(ItemBuilder.of(Material.BARRIER).noName());
        inventory.set(ItemBuilder.of(Material.DIAMOND_AXE), 3, 4);
        inventory.fill(ItemBuilder.of(Material.GRAY_STAINED_GLASS_PANE).noName());
        inventory.clear(7, 10);
        player.openInventory(inventory.build());
    }

}
