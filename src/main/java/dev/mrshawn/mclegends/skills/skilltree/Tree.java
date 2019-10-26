package dev.mrshawn.mclegends.skills.skilltree;

import fr.minuskube.inv.SmartInventory;
import org.bukkit.ChatColor;

public class Tree {

	public SmartInventory inventory = SmartInventory.builder()
			.id("tree")
			.provider(null)
			.size(6, 9)
			.title(ChatColor.DARK_GREEN + "Skilltree")
			.closeable(true)
			.build();


}
