package ru.tairesh.bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
//import org.bukkit.inventory.ItemStack;

public class noTNTBlockListener extends BlockListener {

	private noTNT plugin;
	
	public noTNTBlockListener(noTNT instance) {
		this.plugin = instance;
		
	}
	
	public void onBlockPlace(BlockPlaceEvent event) {
		if (event.isCancelled()) return;
		
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		
		if (block.getType() == Material.TNT && player.hasPermission("notnt.tnt-allow") == false) {
			block.setType(Material.CAKE_BLOCK);
			player.sendMessage(ChatColor.RED + "You don't have permissions to use TNT!");
			
			plugin.logMessage(player.getName() + " placed a TNT at " + block.getX() + "," + block.getY() + "," + block.getZ());
			
		}
	}
	
	public void onBlockBreak (BlockBreakEvent event) {
		if (event.isCancelled()) return;
		
		Block block = event.getBlock();
		
		if (block.getType() == Material.TNT) {
			event.setCancelled(true);
			block.setType(Material.AIR);
			
	//		block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CAKE, 1));
		}
	}
	
}
