package me.ihavenowlan.inmaintenance;

import me.ihavenowlan.inmaintenance.cmd.CMD;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    public FileConfiguration config = getConfig();

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        config.options().copyDefaults(true);
        this.loadConfig();
        this.saveConfig();

        registerListeners();
        registerCommands();
    }

    public void onDisable() {


    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new CMD(), this);

    }

    public void registerCommands() {
        getCommand("maintenance").setExecutor(new CMD());

    }

    private void loadConfig() {
        this.getConfig().options().header("Customize the Plugin here.");
        this.getConfig().addDefault("main.status", false);
        this.getConfig().addDefault("main.slots", 0);
        this.getConfig().addDefault("message.MOTD.line1", "MOTD LINE 1");
        this.getConfig().addDefault("message.MOTD.line2", "MOTD LINE 2");
        this.getConfig().addDefault("message.prefix", "§cMaintenance §8>§r");
        this.getConfig().addDefault("message.enabled", "§a§lenabled§r");
        this.getConfig().addDefault("message.disabled", "§c§ldisabled§r");
        this.getConfig().addDefault("message.status", "Maintenance is currently #STATUS#!");
        this.getConfig().addDefault("message.error", "§4✖Error✖§r");
        this.getConfig().addDefault("message.nowmaintenanceoff", "Maintenance is now off");
        this.getConfig().addDefault("message.nowmaintenanceon", "Maintenance is now on");
        this.getConfig().addDefault("message.configreload", "Config reloaded");
        this.getConfig().addDefault("message.noperm", "§cYou have no permission to do that");
        this.getConfig().addDefault("message.exclamationmark", true);
        this.getConfig().addDefault("message.kick.line1", "§cMaintenance");
        this.getConfig().addDefault("message.kick.line2", "");
        this.getConfig().addDefault("message.kick.line3", "§fMaintenance is currently Active");
        this.getConfig().addDefault("message.kick.line4", "");
        this.getConfig().addDefault("message.kick.line5", "§fMore information on https://yourserver.com");
        this.getConfig().addDefault("message.kick.line6", "§fDiscord discord.gg/yourserver");

        this.getConfig().options().copyDefaults(true);

        this.getConfig().getString("main.status", "false");
        this.getConfig().getString("main.slots", "0");
        this.getConfig().getString("message.MOTD.line1", "MOTD LINE 1");
        this.getConfig().getString("message.MOTD.line2", "MOTD LINE 2");
        this.getConfig().getString("message.prefix", "§cMaintenance §8>§r");
        this.getConfig().getString("message.enabled", "§a§lenabled§r");
        this.getConfig().getString("message.disabled", "§c§ldisabled§r");
        this.getConfig().getString("message.status", "Maintenance is currently #STATUS#!");
        this.getConfig().getString("message.error", "§4✖Error✖§r");
        this.getConfig().getString("message.nowmaintenanceoff", "Maintenance is now off");
        this.getConfig().getString("message.nowmaintenanceon", "Maintenance is now on");
        this.getConfig().getString("message.configreload", "Config reloaded");
        this.getConfig().getString("message.noperm", "§cYou have no permission to do that");
        this.getConfig().getString("message.exclamationmark", "true");
        this.getConfig().getString("message.kick.line1", "§cMaintenance");
        this.getConfig().getString("message.kick.line2", "");
        this.getConfig().getString("message.kick.line3", "§fMaintenance is currently Active");
        this.getConfig().getString("message.kick.line4", "");
        this.getConfig().getString("message.kick.line5", "§fMore information on https://yourserver.com");
        this.getConfig().getString("message.kick.line6", "§fDiscord discord.gg/yourserver");

        this.saveConfig();
        this.reloadConfig();
    }
}
