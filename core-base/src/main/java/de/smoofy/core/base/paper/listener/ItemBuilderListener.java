package de.smoofy.core.base.paper.listener;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 06.10.24, 21:52
 */

import de.smoofy.core.api.builder.ItemBuilder;
import de.smoofy.core.base.bootstrap.PaperBootstrap;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

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

    private <T extends Event> void accept(T event) {
        if (this.key == null) {
            return;
        }

        ItemStack itemStack = null;
        if (event instanceof InventoryClickEvent) {
            itemStack = ((InventoryClickEvent) event).getCurrentItem();
        } else if (event instanceof PlayerInteractEvent) {
            itemStack = ((PlayerInteractEvent) event).getItem();
        }
        if (itemStack == null) {
            return;
        }

        for (var item : ItemBuilder.eventItems) {
            if (!item.clazz().isAssignableFrom(event.getClass())) {
                continue;
            }
            if (!itemStack.getItemMeta().getPersistentDataContainer().has(this.key)) {
                continue;
            }
            if (!Objects.equals(item.key(),
                    itemStack.getItemMeta().getPersistentDataContainer().get(this.key, PersistentDataType.STRING))) {
                continue;
            }
            item.accept(event);
        }
    }
}
