package me.secondflightqb.CheatyStick;

import java.lang.reflect.Array;
import java.util.*;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryHelper {
	
	/*
	private Player player;
	private ItemStack item0;
	private ItemStack item1;
	private ItemStack item2;
	private ItemStack item3;
	private ItemStack item4;
	private ItemStack item5;
	private ItemStack item6;
	private ItemStack item7;
	private ItemStack item8;
	*/
	
	//private ItemStack[] itemArray,
	//itemArray = new ItemStack[9];
	
	public InventoryHelper(/*Player startPlayer, ItemStack startItem0, ItemStack startItem1, ItemStack startItem2, ItemStack startItem3, ItemStack startItem4, ItemStack startItem5, ItemStack startItem6, ItemStack startItem7, ItemStack startItem8*/){
		
		/*
		player = startPlayer;
		item0 = startItem0;
		item1 = startItem1;
		item2 = startItem2;
		item3 = startItem3;
		item4 = startItem4;
		item5 = startItem5;
		item6 = startItem6;
		item7 = startItem7;
		item8 = startItem8;
		*/
		
	
	
	}
	
	static Map<String, List<ItemStack>> playerMap = new HashMap<String, List<ItemStack>>();
	
	static void storeHotbar(Player player, ItemStack item0, ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5, ItemStack item6, ItemStack item7, ItemStack item8) {
		List<ItemStack> playerHotbar = new ArrayList<ItemStack>();
		
		playerHotbar.add(item0);
		playerHotbar.add(item1);
		playerHotbar.add(item2);
		playerHotbar.add(item3);
		playerHotbar.add(item4);
		playerHotbar.add(item5);
		playerHotbar.add(item6);
		playerHotbar.add(item7);
		playerHotbar.add(item8);
		
		//this is the point where I stop and realize how utterly horrible my code is
		//oops
		//
		//heh heh
		
		playerMap.put(player.getDisplayName(), playerHotbar);
	}
	
	static void restoreHotbar(Player player) {
	
		List<ItemStack> playerList = playerMap.get(player.getDisplayName());
		
		player.getInventory().setItem(0, playerList.get(0));
		player.getInventory().setItem(1, playerList.get(1));
		player.getInventory().setItem(2, playerList.get(2));
		player.getInventory().setItem(3, playerList.get(3));
		player.getInventory().setItem(4, playerList.get(4));
		player.getInventory().setItem(5, playerList.get(5));
		player.getInventory().setItem(6, playerList.get(6));
		player.getInventory().setItem(7, playerList.get(7));
		player.getInventory().setItem(8, playerList.get(8));
		
		//every time i make one of these absurd code copies, I think about how someone
		//is going to come along and see this on github and shudder
		//
		//or worse, it will be my future or prospective future boss
		//
		//
		//...
		//
		//this could end badly
		
	//return item0, item1, item2, item3, item4, item5, item6, item7, item8;
	}
}
