package dev.jamieisgeek.easyteleport.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TeleportUtil {

    public static void TeleportToPlayer(InventoryClickEvent e, Player p, Player tpPlayer) {

        Location tpLocation = tpPlayer.getLocation();

        if(p.hasPermission("etp.tp")) {

            p.sendMessage(ChatColor.GREEN + "Teleporting...");
            p.teleport(tpLocation);
            p.closeInventory();
            p.sendMessage(ChatColor.GREEN + "Teleported you to: " + ChatColor.RED + tpPlayer.getDisplayName() + ChatColor.GREEN + "'s Location!");
        } else {
            p.closeInventory();
            p.sendMessage(ChatColor.RED + "Error: Missing Permission" + ChatColor.WHITE + "etp.tp");
        }
    }

}
