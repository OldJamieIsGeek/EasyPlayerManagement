package dev.jamieisgeek.easyteleport;

import dev.jamieisgeek.easyteleport.Listeners.MenuClickListener;
import dev.jamieisgeek.easyteleport.commands.ListCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyTeleport extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("list").setExecutor(new ListCommand());
        getServer().getPluginManager().registerEvents(new MenuClickListener(), this);

        this.getLogger.info(" ");
        this.getLogger.info("Plugin Enabled!");
        this.getLogger.info(" ");

    }

    @Override
    public void onDisable() {

        this.getLogger.info( " ");
        this.getLogger.info("Plugin Disabled!");
        this.getLogger.info(" ");
    }
}
