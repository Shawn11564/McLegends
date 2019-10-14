package dev.mrshawn.mclegends.menus.items;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Consumer;

public class InventoryItem {

	@NotNull
	private final ItemStack item;

	@NotNull
	private final Consumer<InventoryClickEvent> action;

	@NotNull
	private final UUID uuid = UUID.randomUUID();

	public InventoryItem(@NotNull ItemStack item, @NotNull Consumer<InventoryClickEvent> action) {
		if (action == null) {
			this.action = event -> {};
		} else {
			this.action = action;
		}
		this.item = item;
	}

	public InventoryItem(@NotNull ItemStack item) {
		this(item, null);
	}

	@NotNull
	@Contract(pure = true)
	public Consumer<InventoryClickEvent> getAction() {
		return action;
	}

	@NotNull
	@Contract(pure = true)
	public ItemStack getItem() {
		return item;
	}

	@NotNull
	@Contract(pure = true)
	public UUID getUUID() {
		return uuid;
	}
}
