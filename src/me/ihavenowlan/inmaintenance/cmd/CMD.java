package me.ihavenowlan.inmaintenance.cmd;

import me.ihavenowlan.inmaintenance.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.Iterator;

public class CMD implements CommandExecutor, Listener {
    String exclamation = "\n§c████████\n§c ███§f██§c███ \n§c ███§f██§c███ \n§c ███§f██§c███ \n§c ███§f██§c███ \n§c ████████ \n§c ███§f██§c███ \n§c████████\n\n";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        String arg;
        String prefix = Main.getInstance().getConfig().getString("message.prefix");
        if (commandSender.hasPermission("maintenance.use")) {
            if (args.length == 1) {
                arg = args[0];
                if (arg.equalsIgnoreCase("off")) {
                    Bukkit.broadcastMessage(prefix + " " + Main.getInstance().getConfig().getString("message.nowmaintenanceoff"));
                    Main.getInstance().getConfig().set("main.status", false);
                    Main.getInstance().getConfig().set("main.status", false);
                    Main.getInstance().saveConfig();
                    return false;

                }
                if (arg.equalsIgnoreCase("on")) {
                    Bukkit.broadcastMessage(prefix + " " + Main.getInstance().getConfig().getString("message.nowmaintenanceon"));
                    Iterator var8 = Bukkit.getOnlinePlayers().iterator();

                    while (var8.hasNext()) {
                        Player pp = (Player) var8.next();
                        if (!pp.hasPermission("maintenance.bypass")) {
                            if (Main.getInstance().getConfig().getBoolean("message.exclamationmark") == true) {
                                String config1 = Main.getInstance().getConfig().getString("message.kick.line1");
                                config1 = config1;
                                String config2 = Main.getInstance().getConfig().getString("message.kick.line2");
                                config2 = config2;
                                String config3 = Main.getInstance().getConfig().getString("message.kick.line3");
                                config3 = config3;
                                String config4 = Main.getInstance().getConfig().getString("message.kick.line4");
                                config4 = config4;
                                String config5 = Main.getInstance().getConfig().getString("message.kick.line5");
                                config5 = config5;
                                String config6 = Main.getInstance().getConfig().getString("message.kick.line6");
                                config6 = config6;
                                pp.kickPlayer(exclamation + config1 + "\n" + config2 + "\n" + config3 + "\n" + config4 + "\n" + config5 + "\n" + config6);
                            } else {
                                String config1 = Main.getInstance().getConfig().getString("message.kick.line1");
                                config1 = config1;
                                String config2 = Main.getInstance().getConfig().getString("message.kick.line2");
                                config2 = config2;
                                String config3 = Main.getInstance().getConfig().getString("message.kick.line3");
                                config3 = config3;
                                String config4 = Main.getInstance().getConfig().getString("message.kick.line4");
                                config4 = config4;
                                String config5 = Main.getInstance().getConfig().getString("message.kick.line5");
                                config5 = config5;
                                String config6 = Main.getInstance().getConfig().getString("message.kick.line6");
                                config6 = config6;
                                pp.kickPlayer(config1 + "\n" + config2 + "\n" + config3 + "\n" + config4 + "\n" + config5 + "\n" + config6);
                            }

                        }

                    }
                    Main.getInstance().getConfig().set("main.status", true);
                    Main.getInstance().getConfig().set("main.status", true);
                    Main.getInstance().saveConfig();
                    return false;

                }
                if (arg.equalsIgnoreCase("reload")) {
                    commandSender.sendMessage(prefix + " " + Main.getInstance().getConfig().getString("message.configreload"));
                    Main.getInstance().reloadConfig();
                    Main.getInstance().saveConfig();
                }
            } else if (args.length == 0) {
                if (Main.getInstance().getConfig().getBoolean("main.status") == true) {
                    commandSender.sendMessage(prefix + " " + Main.getInstance().getConfig().getString("message.status").replaceAll("#STATUS#", Main.getInstance().getConfig().getString("message.enabled")));
                } else {
                    commandSender.sendMessage(prefix + " " + Main.getInstance().getConfig().getString("message.status").replaceAll("#STATUS#", Main.getInstance().getConfig().getString("message.disabled")));
                }
            } else {
                commandSender.sendMessage(prefix + " " + Main.getInstance().getConfig().getString("message.error"));

            }
        } else {
            commandSender.sendMessage(prefix + " " + Main.getInstance().getConfig().getString("message.noperm"));


        }
        return false;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        System.out.println(e.getPlayer().getName() + Main.getInstance().getConfig().getBoolean("main.status") + this.exclamation);
        if (Main.getInstance().getConfig().getBoolean("main.status") == true && !e.getPlayer().hasPermission("maintenance.bypass")) {
            if (Main.getInstance().getConfig().getBoolean("message.exclamationmark") == true) {
                String config1 = Main.getInstance().getConfig().getString("message.kick.line1");
                config1 = config1;
                String config2 = Main.getInstance().getConfig().getString("message.kick.line2");
                config2 = config2;
                String config3 = Main.getInstance().getConfig().getString("message.kick.line3");
                config3 = config3;
                String config4 = Main.getInstance().getConfig().getString("message.kick.line4");
                config4 = config4;
                String config5 = Main.getInstance().getConfig().getString("message.kick.line5");
                config5 = config5;
                String config6 = Main.getInstance().getConfig().getString("message.kick.line6");
                config6 = config6;
                e.disallow(null, exclamation + config1 + "\n" + config2 + "\n" + config3 + "\n" + config4 + "\n" + config5 + "\n" + config6);
            } else {
                String config1 = Main.getInstance().getConfig().getString("message.kick.line1");
                config1 = config1;
                String config2 = Main.getInstance().getConfig().getString("message.kick.line2");
                config2 = config2;
                String config3 = Main.getInstance().getConfig().getString("message.kick.line3");
                config3 = config3;
                String config4 = Main.getInstance().getConfig().getString("message.kick.line4");
                config4 = config4;
                String config5 = Main.getInstance().getConfig().getString("message.kick.line5");
                config5 = config5;
                String config6 = Main.getInstance().getConfig().getString("message.kick.line6");
                config6 = config6;
                e.disallow(null, config1 + "\n" + config2 + "\n" + config3 + "\n" + config4 + "\n" + config5 + "\n" + config6);
            }

        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        if (Main.getInstance().getConfig().getBoolean("main.status") == true) {
            if (!(e.getPlayer().hasPermission("maintenance.bypass"))) {
                e.setLeaveMessage("");
            }

        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (Main.getInstance().getConfig().getBoolean("main.status") == true) {
            if (!(e.getPlayer().hasPermission("maintenance.bypass"))) {
                e.setQuitMessage("");
            }

        }
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        if (Main.getInstance().getConfig().getBoolean("main.status") == true) {
            int slots = Main.getInstance().getConfig().getInt("main.slots");
            e.setMaxPlayers(slots);
            String MOTD1 = Main.getInstance().getConfig().getString("message.MOTD.line1");
            String MOTD2 = Main.getInstance().getConfig().getString("message.MOTD.line2");
            e.setMotd(MOTD1 + "\n" + MOTD2);
        }

    }
}
