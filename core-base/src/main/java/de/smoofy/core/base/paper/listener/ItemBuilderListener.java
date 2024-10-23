/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.paper.listener;

import de.smoofy.core.api.builder.ItemBuilder;
import de.smoofy.core.base.bootstrap.PaperBootstrap;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public class ItemBuilderListener implements Listener {

    private final NamespacedKey key;

    public ItemBuilderListener() {
        this.key = NamespacedKey.fromString("core:key");
        Bukkit.getPluginManager().registerEvents(this, PaperBootstrap.instance());
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        this.accept(event);
    }

    @EventHandler
    public void onAct(PlayerInteractEvent event) {
        this.accept(event);
    }

    @EventHandler
    public void onDrop(EntityDropItemEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        this.accept(event);
    }

    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        this.accept(event);
    }

    private <T extends Event> void accept(T event) {
        if (this.key == null) {
            return;
        }

        var itemStack = this.itemStack(event);
        if (itemStack == null) {
            return;
        }
        if (!itemStack.getItemMeta().getPersistentDataContainer().has(this.key)) {
            return;
        }

        var item = ItemBuilder.Cache.item(itemStack.getItemMeta().getPersistentDataContainer().get(this.key, PersistentDataType.STRING));
        if (item == null) {
            return;
        }
        if (!item.clazz().isAssignableFrom(event.getClass())) {
            return;
        }
        item.accept(event);
    }

    private <T extends Event> @Nullable ItemStack itemStack(T event) {
        ItemStack itemStack = null;
        if (event instanceof InventoryClickEvent) {
            itemStack = ((InventoryClickEvent) event).getCurrentItem();
        } else if (event instanceof PlayerInteractEvent) {
            itemStack = ((PlayerInteractEvent) event).getItem();
        } else if (event instanceof EntityDropItemEvent) {
            itemStack = ((EntityDropItemEvent) event).getItemDrop().getItemStack();
        } else if (event instanceof EntityPickupItemEvent) {
            itemStack = ((EntityPickupItemEvent) event).getItem().getItemStack();
        }
        return itemStack;
    }
}
