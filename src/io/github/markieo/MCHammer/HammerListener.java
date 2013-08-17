package io.github.markieo.MCHammer;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HammerListener implements Listener{
	private Main plugin;
private CommandExec commandexec;
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player dmgd = (Player) e.getEntity();
			if (e.getDamager() instanceof Player) {
				Player player = (Player) e.getDamager();
				if (player.getItemInHand() != null) {
					if (player.getItemInHand().equals(commandexec.hammer())) {
						dmgd.kickPlayer("You have been hit by MCHammer see you around!!");
						plugin.getServer().broadcastMessage(
						ChatColor.DARK_RED + dmgd.getDisplayName()+ plugin.getConfig().getString("MCHammer.Hammer.BroadcastMessage"));
						dmgd.playSound(dmgd.getLocation(), Sound.AMBIENCE_THUNDER, 1, 1);

					}
				}
			}
		}
	}	
	
	
	
	
}
