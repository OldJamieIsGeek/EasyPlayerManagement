package dev.jamieisgeek.easyteleport.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerInventoryUtil {

    public static void openInventory(Player p) {

        if(p.getServer().getOnlinePlayers().size() > 54) {
            p.sendMessage(ChatColor.RED + "Sorry, there are too many players online for this version!");
            p.sendMessage(ChatColor.RED + "Please wait for the newer version to come out!");
            return;
        }
        ArrayList<Player> list = new ArrayList<>(p.getServer().getOnlinePlayers());

        Inventory playerList;
        playerList = Bukkit.createInventory(p, 54, ChatColor.DARK_GREEN + "Online Players");

        for (Player player : list) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();

            int playerX = ((int) player.getLocation().getX());
            int playerY = ((int) player.getLocation().getY());
            int playerZ = ((int) player.getLocation().getZ());
            int playerXP = ((int) player.getExp());
            String playerDim = player.getWorld().getEnvironment().toString();
            String playerGM = player.getGameMode().toString();

            meta.setDisplayName(ChatColor.GREEN + player.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "Player Health: " + ChatColor.WHITE + player.getHealth());
            lore.add(ChatColor.GREEN + "Player Gamemode: " + ChatColor.WHITE + playerGM);
            lore.add(ChatColor.RED + "Location: " + ChatColor.WHITE + "X: " + playerX + " Y: " + playerY + " Z: " + playerZ);
            lore.add(ChatColor.RED + "World: " + ChatColor.WHITE + playerDim);
            lore.add("");
            lore.add(ChatColor.GOLD + "Click to teleport!");

            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            playerList.addItem(playerHead);
        }
        p.openInventory(playerList);
    }
}
