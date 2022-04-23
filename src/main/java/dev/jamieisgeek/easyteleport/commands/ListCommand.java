package dev.jamieisgeek.easyteleport.commands;

import dev.jamieisgeek.easyteleport.Utils.PlayerInventoryUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class ListCommand implements CommandExecutor {

    Logger logger = Bukkit.getLogger();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(p.hasPermission("etp.list")) {
                PlayerInventoryUtil.openInventory(p);
            } else {
                p.sendMessage(ChatColor.RED + "Error: Missing Permission: " + ChatColor.WHITE + "etp.list");
            }
        } else {
            logger.warning("You must run this command in-game!");
        }

        return true;
    }
}
