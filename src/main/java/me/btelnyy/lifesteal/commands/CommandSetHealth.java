package me.btelnyy.lifesteal.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;

public class CommandSetHealth implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args){
        if(args.length < 2){
            sender.sendMessage(ChatColor.RED + "Error: Invalid syntax. Usage: /sethealth <player> <amount>");
            return true;
        }
        if(Bukkit.getPlayer(args[0]) == null){
            sender.sendMessage(ChatColor.RED + "Error: Player not found.");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        double health = Double.valueOf(args[1]);
        target.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
        sender.sendMessage(ChatColor.GRAY + "You have set " + target.getName() + "'s health to " + health);
        return true;
    }
}
