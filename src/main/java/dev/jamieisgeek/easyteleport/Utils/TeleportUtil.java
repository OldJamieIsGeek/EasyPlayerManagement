package dev.jamieisgeek.easyteleport.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TeleportUtil {

    public static void TeleportToPlayer(InventoryClickEvent e, Player p, Player tpPlayer) {

        if(p.hasPermission("etp.tp")) {
            p.closeInventory();
            p.sendMessage(ChatColor.RED + "Error: Missing Permission" + ChatColor.WHITE + "etp.tp");
            return;
        }

        p.sendMessage(ChatColor.GREEN + "Teleporting...");
        p.teleport(tpPlayer.getLocation());
        p.closeInventory();
        p.sendMessage(ChatColor.GREEN + "Teleported you to: " + ChatColor.RED + tpPlayer.getDisplayName() + ChatColor.GREEN + "'s Location!");
       
    }

}
