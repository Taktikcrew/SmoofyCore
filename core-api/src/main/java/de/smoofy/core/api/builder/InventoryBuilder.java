package de.smoofy.core.api.builder;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 10:55
 */

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InventoryBuilder {

    private final Inventory inventory;

    private InventoryBuilder(@NotNull Inventory inventory) {
        this.inventory = inventory;
    }

    public static InventoryBuilder of(@NotNull Inventory inventory) {
        return new InventoryBuilder(inventory);
    }

    private InventoryBuilder(@Nullable Component title, int rows) {
        if (title != null) {
            this.inventory = Bukkit.createInventory(null, rows*9, title);
        } else {
           this.inventory = Bukkit.createInventory(null, rows*9);
        }
    }

    public static InventoryBuilder of(@Nullable Component title, int rows) {
        return new InventoryBuilder(title, rows);
    }

    private InventoryBuilder(@Nullable InventoryHolder inventoryHolder, @Nullable Component title, int rows) {
        if (title != null) {
            this.inventory = Bukkit.createInventory(inventoryHolder, rows*9, title);
        } else {
            this.inventory = Bukkit.createInventory(inventoryHolder, rows*9);
        }
    }

    public static InventoryBuilder of(@Nullable InventoryHolder inventoryHolder, @Nullable Component title, int rows) {
        return new InventoryBuilder(inventoryHolder, title, rows);
    }

    private InventoryBuilder(InventoryType inventoryType, @Nullable Component title) {
        if (title != null) {
            this.inventory = Bukkit.createInventory(null, inventoryType, title);
        } else {
            this.inventory = Bukkit.createInventory(null, inventoryType);
        }
    }

    public static InventoryBuilder of(InventoryType inventoryType, @Nullable Component title) {
        return new InventoryBuilder(inventoryType, title);
    }

    private InventoryBuilder(@Nullable InventoryHolder inventoryHolder, InventoryType inventoryType, @Nullable Component title) {
        if (title != null) {
            this.inventory = Bukkit.createInventory(inventoryHolder, inventoryType, title);
        } else {
            this.inventory = Bukkit.createInventory(inventoryHolder, inventoryType);
        }
    }

    public static InventoryBuilder of(@Nullable InventoryHolder inventoryHolder, InventoryType inventoryType, @Nullable Component title) {
        return new InventoryBuilder(inventoryHolder, inventoryType, title);
    }

    public InventoryBuilder set(ItemBuilder itemBuilder, int... slots) {
        for (int slot : slots) {
            inventory.setItem(slot, itemBuilder.build());
        }
        return this;
    }

    public InventoryBuilder clear(int... slots) {
        for (int slot : slots) {
            inventory.clear(slot);
        }
        return this;
    }

    public InventoryBuilder fill(ItemBuilder itemBuilder) {
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) != null) {
                continue;
            }
            inventory.setItem(i, itemBuilder.build());
        }
        return this;
    }

    public InventoryBuilder add(ItemBuilder itemBuilder) {
        inventory.addItem(itemBuilder.build());
        return this;
    }

    public Inventory build() {
        return this.inventory;
    }

}
