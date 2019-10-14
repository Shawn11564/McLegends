package dev.mrshawn.mclegends.menus;

import dev.mrshawn.mclegends.McLegends;
import dev.mrshawn.mclegends.menus.items.InventoryItem;
import dev.mrshawn.mclegends.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.Map;
import java.util.function.Consumer;

public class StaticMenu {

	private McLegends main;
	private Inventory inventory;
	private String title;
	private int rows;
	private Consumer<InventoryCloseEvent> onClose;
	private Map<Integer, InventoryItem> items;

	public StaticMenu(McLegends main, String title, int rows) {
		this.main = main;
		this.title = title;
		this.rows = rows;

		inventory = Bukkit.createInventory(null, rows * 9, Chat.colorize(title));
	}

	public void addItem(InventoryItem item, int x, int y) {
		inventory.setItem(x + (9 * y), item.getItem());
	}
}
