package dev.jamieisgeek.easyteleport.commands;

import dev.jamieisgeek.easyteleport.Utils.PlayerInventoryUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCommand implements CommandExecutor {

    Logger logger = Bukkit.getLogger();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!sender instanceof Player) {
            logger.warning("This command must be run by a player!");
        }
        
        Player p = (Player) sender;

        if(!p.hasPermission("etp.list")) {
            p.sendMessage(ChatColor.RED + "Error: Missing Permission: " + ChatColor.WHITE + "etp.list");
            return;
        }
        
        PlayerInventoryUtil.openInventory(p);

        return true;
    }
}
