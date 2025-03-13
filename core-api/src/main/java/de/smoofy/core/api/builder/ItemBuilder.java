/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.builder;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@Getter
@Accessors(fluent = true)
public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    private String key;
    private Class<? extends Event> clazz;
    private Consumer<? extends Event> consumer;

    private ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack.clone();
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public static ItemBuilder of(@NotNull ItemStack itemStack) {
        return new ItemBuilder(itemStack);
    }

    private ItemBuilder(Material material) {
        this(new ItemStack(material));
    }

    public static ItemBuilder of(@NotNull Material material) {
        return new ItemBuilder(material);
    }

    public ItemBuilder name(@NotNull Component name) {
        this.itemMeta.displayName(name);
        return this;
    }

    public ItemBuilder noName() {
        this.itemMeta.displayName(Component.text(" "));
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder durability(int damage) {
        if (this.itemMeta instanceof Damageable damageable) {
            damageable.setDamage(damage);
            this.itemStack.setItemMeta(damageable);
        }
        return this;
    }

    public ItemBuilder itemFlags(ItemFlag... itemFlags) {
        this.itemMeta.addItemFlags(itemFlags);
        return this;
    }

    public ItemBuilder unbreakable() {
        this.itemMeta.setUnbreakable(true);
        return this;
    }

    public ItemBuilder enchant(int level, @NotNull Enchantment... enchantments) {
        Arrays.stream(enchantments).forEach(enchantment -> this.itemStack.addEnchantment(enchantment, level));
        return this;
    }

    public ItemBuilder enchantUnsafe(int level, @NotNull Enchantment... enchantments) {
        Arrays.stream(enchantments).forEach(enchantment -> this.itemStack.addUnsafeEnchantment(enchantment, level));
        return this;
    }

    public ItemBuilder lore(@NotNull Component... lore) {
        this.itemMeta.lore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder lore(List<Component> lore) {
        this.itemMeta.lore(lore);
        return this;
    }

    public ItemBuilder addLoreLine(@NotNull Component line, int pos) {
        if (this.itemMeta.lore() == null || !this.itemMeta.hasLore()) {
            return this;
        }
        var lore = Lists.newArrayList(Objects.requireNonNull(this.itemMeta.lore()));
        lore.set(pos, line);
        this.itemMeta.lore(lore);
        return this;
    }

    public ItemBuilder customModelData(int modelData) {
        this.itemMeta.setCustomModelData(modelData);
        return this;
    }

    public <T extends Event> ItemBuilder event(String key, Class<T> clazz, Consumer<T> consumer) {
        this.key = key;
        this.clazz = clazz;
        this.consumer = consumer;

        this.itemMeta.getPersistentDataContainer().set(new NamespacedKey("core", "key"),
                PersistentDataType.STRING, this.key);

        Cache.cache(this);

        return this;
    }

    @SuppressWarnings("unchecked")
    public  void accept(Event event) {
        var eventConsumer = (Consumer<Event>) this.consumer;
        eventConsumer.accept(event);
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

    public static class Cache {

        private static final List<ItemBuilder> itemBuilderCache = Lists.newArrayList();

        public static void cache(ItemBuilder itemBuilder) {
            itemBuilderCache.add(itemBuilder);
        }

        public static ItemBuilder item(String key) {
            return itemBuilderCache.stream().filter(itemBuilder -> itemBuilder.key.equals(key)).findFirst().orElse(null);
        }
    }

}
