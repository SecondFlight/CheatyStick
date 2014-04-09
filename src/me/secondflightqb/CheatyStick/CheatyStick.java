package me.secondflightqb.CheatyStick;

import me.secondflightqb.CheatyStick.InventoryStringDeSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

//import com.comphenix.protocol.ProtocolLibrary;
//import com.comphenix.protocol.ProtocolManager;

public class CheatyStick extends JavaPlugin implements Listener{

	public final Logger logger = Logger.getLogger("Minecraft");
	public static CheatyStick plugin;
	
	//public String inv1;
	//public String inv2;
	//public String inv3;
	//public String inv4;
	//public String inv5;
	//public String inv6;
	//public String inv7;
	//public String inv8;
	//public String inv9;
	
	//private ProtocolManager protocolManager;
	
	//Things to do when loading
	//@Override
	//public void onLoad() {
		//protocolManager = ProtocolLibrary.getProtocolManager();
	//}
	
	
	//prints text to console when disabled
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled.");
	
	}
	
	//prints text to console when enabled
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " has been enabled.");
		getServer().getPluginManager().registerEvents(this, this);
	}

	static Map<String, Boolean> stickIsActive = new HashMap<String, Boolean>();
	
	//defines stick item
	public ItemStack stickItemStack = (new ItemStack(Material.STICK)); 
	
	{
		ItemMeta meta = stickItemStack.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		//lore.add(ChatColor.DARK_AQUA + "Right-click: use quick-bind");
		//CHECK ON EVENT HANDELER MUST BE CHANGED IF THIS IS CHANGED
		lore.add(ChatColor.DARK_AQUA + "Left-click: open menu");
		
		meta.setDisplayName(ChatColor.GOLD + "Cheaty Stick");
		meta.setLore(lore);
		
		stickItemStack.setItemMeta(meta);
	}
	
	//
	//section for defining gui items
	//
	
	//multi-use items
	public ItemStack exitItem = (new ItemStack(Material.REDSTONE_BLOCK));
	{
		ItemMeta meta = exitItem.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.DARK_AQUA + "Note: You can also exit by opening the inventory.");
		
		meta.setDisplayName(ChatColor.RED + "EXIT");
		meta.setLore(lore);
		
		exitItem.setItemMeta(meta);
	}
	
	//main gui screen
	public ItemStack guiScreenMain1_1 = (new ItemStack(Material.FEATHER)); {
		ItemMeta meta = guiScreenMain1_1.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.DARK_AQUA + "Left-click: open sub-menu");
		lore.add(ChatColor.DARK_AQUA + "Right-click: toggle flying on/off");
		lore.add(ChatColor.DARK_AQUA + "Flight: " + ChatColor.RED + "OFF");
		
		meta.setDisplayName(ChatColor.GOLD + "Flying/Invincibility");
		meta.setLore(lore);
		
		guiScreenMain1_1.setItemMeta(meta);
	}
	
	public ItemStack guiScreenMain1_2 = (new ItemStack(Material.FEATHER)); {
		ItemMeta meta = guiScreenMain1_2.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.DARK_AQUA + "Left-click: open sub-menu");
		lore.add(ChatColor.DARK_AQUA + "Right-click: toggle flying on/off");
		lore.add(ChatColor.DARK_AQUA + "Flight: " + ChatColor.GREEN + "ON");
		
		meta.setDisplayName(ChatColor.GOLD + "Flying/Invincibility");
		meta.setLore(lore);
		
		guiScreenMain1_2.setItemMeta(meta);
	}
	
	//listener for click
	@EventHandler
	public void clickListener(PlayerInteractEvent event) {
		
		if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			Player player = event.getPlayer();
			ItemStack item = player.getItemInHand();
			
			if (item.hasItemMeta() 
					&& item.getItemMeta().hasDisplayName()
					&& item.getItemMeta().hasLore() 
					&& item.getItemMeta().getDisplayName().equals(ChatColor.RED + "EXIT") 
					&& item.getItemMeta().getLore().contains(ChatColor.DARK_AQUA + "Note: You can also exit by opening the inventory.")) {
				
				InventoryHelper.restoreHotbar(player);
				stickIsActive.put(player.getDisplayName(), false);
			}
			
			if (item.hasItemMeta() 
					&& item.getItemMeta().hasDisplayName()
					&& item.getItemMeta().hasLore() 
					&& item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Cheaty Stick") 
					&& item.getItemMeta().getLore().contains(ChatColor.DARK_AQUA + "Left-click: open menu")) {
				
				
				
				
				
				InventoryHelper.storeHotbar(player, player.getInventory().getItem(0), player.getInventory().getItem(1), player.getInventory().getItem(2), player.getInventory().getItem(3), player.getInventory().getItem(4), player.getInventory().getItem(5), player.getInventory().getItem(6), player.getInventory().getItem(7), player.getInventory().getItem(8));
				
				player.getInventory().setItem(0, null);
				player.getInventory().setItem(1, null);
				player.getInventory().setItem(2, null);
				player.getInventory().setItem(3, null);
				player.getInventory().setItem(4, null);
				player.getInventory().setItem(5, null);
				player.getInventory().setItem(6, null);
				player.getInventory().setItem(7, null);
				player.getInventory().setItem(8, null);
				
				if (player.getAllowFlight() == false) {
					player.getInventory().setItem(0, guiScreenMain1_1);
				}else if (player.getAllowFlight() == true) {
					player.getInventory().setItem(0, guiScreenMain1_2);
				}
				
				stickIsActive.put(player.getDisplayName(), true);
				
				player.getInventory().setItem(8, exitItem);
			}
		}
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player player = event.getPlayer();
			ItemStack item = player.getItemInHand();
			
			if (item.hasItemMeta() 
					&& item.getItemMeta().hasDisplayName()
					&& item.getItemMeta().hasLore() 
					&& item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Flying/Invincibility") 
					&& item.getItemMeta().getLore().contains(ChatColor.DARK_AQUA + "Left-click: open sub-menu")) {
				
				if (player.getAllowFlight() == false) {
					
					player.setAllowFlight(true);
					
					player.getInventory().setItem(0, guiScreenMain1_2);
					
					player.playSound(player.getLocation(), Sound.NOTE_PIANO, 10, (float) 1.2);
					
				}else if (player.getAllowFlight() == true) {
					
					player.setAllowFlight(false);
					
					//guiScreenMain1.getItemMeta().getLore().add(2, ChatColor.DARK_AQUA + "Flight: " + ChatColor.RED + "OFF");
					//the original item defined is what we want here
					player.getInventory().setItem(0, guiScreenMain1_1);
					
					player.playSound(player.getLocation(), Sound.NOTE_PIANO, 10, (float) 0.8);
					
				}
			}
		}
	}
	
	@EventHandler
	public void damageListener(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		
		if (entity instanceof Player) {
			Player player = (Player) entity;
			if (stickIsActive.get(player.getDisplayName()) == true) {
				InventoryHelper.restoreHotbar(player);
				stickIsActive.put(player.getDisplayName(), false);
			}
		}
	}
	
	
	
	//commands
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = (Player) sender;
		
		
		
		//gives player CheatyStick
		if(commandLabel.equalsIgnoreCase("cheatystick")) {
			
				player.getInventory().addItem(this.stickItemStack);
			
			}
		
		if(commandLabel.equalsIgnoreCase("test")) {
			ItemStack a = player.getItemInHand();
			ItemStack b = this.stickItemStack;
			
			if(a.getItemMeta() == b.getItemMeta()) {
				player.sendMessage("block in hand is cheatystick");
			}else{
				player.sendMessage("oopsie");
			
			}
			player.getInventory().addItem(b);
			player.getInventory().addItem(a);
		}
		
		return false;
	}
	
	//public void storeHotbar(Player player) {
	//	Inventory i = player.getInventory();
	//	this.inv1 = InventoryStringDeSerializer.InventoryToString(i);
	//}
	//
	//public void restoreHotbar(Player player) {
	//	player.getInventory().clear();
	//	Inventory i = InventoryStringDeSerializer.StringToInventory(this.inv1);
	//	player.getInventory().setContents(i.getContents());
	//	this.inv1 = null;
	//}
}






