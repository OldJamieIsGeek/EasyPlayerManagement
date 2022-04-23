package dev.jamieisgeek.easyteleport;

import dev.jamieisgeek.easyteleport.Listeners.MenuClickListener;
import dev.jamieisgeek.easyteleport.commands.ListCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class EasyTeleport extends JavaPlugin {

    Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {

        getCommand("list").setExecutor(new ListCommand());
        getServer().getPluginManager().registerEvents(new MenuClickListener(), this);

        logger.info(" ");
        logger.info("[EasyTP] | Plugin Enabled!");
        logger.info(" ");

    }

    @Override
    public void onDisable() {

        logger.info( " ");
        logger.info("[EasyTP] | Plugin Disabled!");
        logger.info(" ");
    }
}
