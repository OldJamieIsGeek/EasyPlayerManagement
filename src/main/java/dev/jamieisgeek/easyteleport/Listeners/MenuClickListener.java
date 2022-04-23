package dev.jamieisgeek.easyteleport.Listeners;

import dev.jamieisgeek.easyteleport.Utils.TeleportUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuClickListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "Online Players")) {
            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                Player tpPlayer = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                TeleportUtil.TeleportToPlayer(e, p, tpPlayer);
                e.setCancelled(true);
            }
        }
    }
}
