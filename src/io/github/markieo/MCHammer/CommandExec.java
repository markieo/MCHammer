package io.github.markieo.MCHammer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandExec implements CommandExecutor{
private Main plugin;
public ItemStack hammer(){		
	ItemStack Hammer = new ItemStack(Material.getMaterial(276));
	List<String> lore = new ArrayList<String>();
		ItemMeta HammerMeta = Hammer.getItemMeta();
		HammerMeta.setDisplayName(plugin.getConfig().getString("MCHammer.Hammer.DisplayName"));
		lore.add(ChatColor.GRAY + plugin.getConfig().getString("MCHammer.Hammer.Lore"));
		HammerMeta.setLore(lore);
		Hammer.setItemMeta(HammerMeta);
		return Hammer;

	}
public CommandExec(Main plugin){
	this.plugin = plugin;
}

public boolean onCommand(CommandSender sender, Command cmd, String label,
		String[] args) {
	if (cmd.getName().equalsIgnoreCase("hammer")) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.setItemInHand(hammer());
			player.sendMessage("[MCHammer]" + ChatColor.RED + "You have been given the " + plugin.getConfig().getString("MCHammer.Hammer.DisplayName") + ". Enjoy!!");
		} else {
			sender.sendMessage("This is a player command!");
			return false;
		}
	}
	return true;
}
}


