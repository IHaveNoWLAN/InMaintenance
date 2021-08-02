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
    boolean onmaintenance = false;
    String exclamation = "§c████████\n§c███§f██§c███ \n§c███§f██§c███ \n§c███§f██§c███ \n§c███§f██§c███ \n§c████████ \n§c███§f██§c███ \n§c████████\n\n";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        String arg;
        String prefix = Main.getInstance().config.getString("message.prefix").replaceAll("&", "§");
        if (commandSender.hasPermission("maintenance.use")) {
            if (args.length == 1) {
                arg = args[0];
                if (arg.equalsIgnoreCase("off")) {
                    Bukkit.broadcastMessage(prefix + " " + Main.getInstance().config.getString("message.nowmaintenanceoff").replaceAll("&", "§"));
                    Main.getInstance().config.set("main.status", false);
                    this.onmaintenance = false;
                    Main.getInstance().config.set("main.status", false);
                    Main.getInstance().saveConfig();
                    return false;

                }
                if (arg.equalsIgnoreCase("on")) {
                    Bukkit.broadcastMessage(prefix + " " + Main.getInstance().config.getString("message.nowmaintenanceon").replaceAll("&", "§"));
                    Iterator var8 = Bukkit.getOnlinePlayers().iterator();

                    while (var8.hasNext()) {
                        Player pp = (Player) var8.next();
                        if (!pp.hasPermission("maintenance.bypass")) {
                            if (Main.getInstance().config.getBoolean("message.exclamationmark") == true) {
                                String config1 = Main.getInstance().getConfig().getString("message.kick.line1").replaceAll("&", "§");
                                config1 = config1.replaceAll("&", "§");
                                String config2 = Main.getInstance().getConfig().getString("message.kick.line2").replaceAll("&", "§");
                                config2 = config2.replaceAll("&", "§");
                                String config3 = Main.getInstance().getConfig().getString("message.kick.line3").replaceAll("&", "§");
                                config3 = config3.replaceAll("&", "§");
                                String config4 = Main.getInstance().getConfig().getString("message.kick.line4").replaceAll("&", "§");
                                config4 = config4.replaceAll("&", "§");
                                String config5 = Main.getInstance().getConfig().getString("message.kick.line5").replaceAll("&", "§");
                                config5 = config5.replaceAll("&", "§");
                                String config6 = Main.getInstance().getConfig().getString("message.kick.line6").replaceAll("&", "§");
                                config6 = config6.replaceAll("&", "§");
                                pp.kickPlayer(exclamation + config1 + "\n" + config2 + "\n" + config3 + "\n" + config4 + "\n" + config5 + "\n" + config6);
                            } else {
                                String config1 = Main.getInstance().getConfig().getString("message.kick.line1").replaceAll("&", "§");
                                config1 = config1.replaceAll("&", "§");
                                String config2 = Main.getInstance().getConfig().getString("message.kick.line2").replaceAll("&", "§");
                                config2 = config2.replaceAll("&", "§");
                                String config3 = Main.getInstance().getConfig().getString("message.kick.line3").replaceAll("&", "§");
                                config3 = config3.replaceAll("&", "§");
                                String config4 = Main.getInstance().getConfig().getString("message.kick.line4").replaceAll("&", "§");
                                config4 = config4.replaceAll("&", "§");
                                String config5 = Main.getInstance().getConfig().getString("message.kick.line5").replaceAll("&", "§");
                                config5 = config5.replaceAll("&", "§");
                                String config6 = Main.getInstance().getConfig().getString("message.kick.line6").replaceAll("&", "§");
                                config6 = config6.replaceAll("&", "§");
                                pp.kickPlayer(config1 + "\n" + config2 + "\n" + config3 + "\n" + config4 + "\n" + config5 + "\n" + config6);
                            }
                            Main.getInstance().config.set("main.status", true);
                            this.onmaintenance = true;
                            Main.getInstance().config.set("main.status", true);
                            Main.getInstance().saveConfig();
                            return true;
                        }

                    }

                }
                if (arg.equalsIgnoreCase("reload")) {
                    commandSender.sendMessage(prefix + Main.getInstance().config.getString("message.configreload").replaceAll("&", "§"));
                    Main.getInstance().reloadConfig();
                    Main.getInstance().saveConfig();
                } else {
                    commandSender.sendMessage(prefix + Main.getInstance().config.getString("message.error").replaceAll("&", "§"));

                }
            } else {
                commandSender.sendMessage(prefix + Main.getInstance().config.getString("message.error").replaceAll("&", "§"));

            }
        } else {
            commandSender.sendMessage(prefix + Main.getInstance().config.getString("message.noperm").replaceAll("&", "§"));

        }
        return false;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if (this.onmaintenance && !e.getPlayer().hasPermission("maintenance.bypass")) {
            if (Main.getInstance().config.getBoolean("message.exclamationmark") == true) {
                String config1 = Main.getInstance().getConfig().getString("message.kick.line1").replaceAll("&", "§");
                config1 = config1.replaceAll("&", "§");
                String config2 = Main.getInstance().getConfig().getString("message.kick.line2").replaceAll("&", "§");
                config2 = config2.replaceAll("&", "§");
                String config3 = Main.getInstance().getConfig().getString("message.kick.line3").replaceAll("&", "§");
                config3 = config3.replaceAll("&", "§");
                String config4 = Main.getInstance().getConfig().getString("message.kick.line4").replaceAll("&", "§");
                config4 = config4.replaceAll("&", "§");
                String config5 = Main.getInstance().getConfig().getString("message.kick.line5").replaceAll("&", "§");
                config5 = config5.replaceAll("&", "§");
                String config6 = Main.getInstance().getConfig().getString("message.kick.line6").replaceAll("&", "§");
                config6 = config6.replaceAll("&", "§");
                e.disallow((PlayerLoginEvent.Result) null, config1 + "\n" + config2 + "\n" + config3 + "\n" + config4);
            } else {
                String config1 = Main.getInstance().getConfig().getString("message.kick.line1").replaceAll("&", "§");
                config1 = config1.replaceAll("&", "§");
                String config2 = Main.getInstance().getConfig().getString("message.kick.line2").replaceAll("&", "§");
                config2 = config2.replaceAll("&", "§");
                String config3 = Main.getInstance().getConfig().getString("message.kick.line3").replaceAll("&", "§");
                config3 = config3.replaceAll("&", "§");
                String config4 = Main.getInstance().getConfig().getString("message.kick.line4").replaceAll("&", "§");
                config4 = config4.replaceAll("&", "§");
                String config5 = Main.getInstance().getConfig().getString("message.kick.line5").replaceAll("&", "§");
                config5 = config5.replaceAll("&", "§");
                String config6 = Main.getInstance().getConfig().getString("message.kick.line6").replaceAll("&", "§");
                config6 = config6.replaceAll("&", "§");
                e.disallow((PlayerLoginEvent.Result) null, config1 + "\n" + config2 + "\n" + config3 + "\n" + config4);
            }

        }
    }
    @EventHandler
    public void onKick(PlayerKickEvent e) {
        if (this.onmaintenance) {
            if (!(e.getPlayer().hasPermission("maintenance.bypass"))) {
                e.setLeaveMessage("");
            }

        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (this.onmaintenance) {
            if (!(e.getPlayer().hasPermission("maintenance.bypass"))) {
                e.setQuitMessage("");
            }

        }
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        if (this.onmaintenance) {
            int slots = Main.getInstance().config.getInt("main.slots");
            e.setMaxPlayers(slots);
            String MOTD1 = Main.getInstance().config.getString("message.MOTD.lind1").replaceAll("&", "§");
            String MOTD2 = Main.getInstance().config.getString("message.MOTD.lind2").replaceAll("&", "§");

            e.setMotd(MOTD1 + "\n" + MOTD2);
        }

    }
}
