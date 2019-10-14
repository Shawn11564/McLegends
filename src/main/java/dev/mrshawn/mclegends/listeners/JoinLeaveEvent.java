package dev.mrshawn.mclegends.listeners;

import dev.mrshawn.mclegends.McLegends;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveEvent implements Listener {

	private McLegends main;

	public JoinLeaveEvent(McLegends main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		main.getPlayerDataManager().addPlayer(event.getPlayer());
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		main.getPlayerDataManager().removePlayer(event.getPlayer());
	}

}
