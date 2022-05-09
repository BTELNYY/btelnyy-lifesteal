package me.btelnyy.lifesteal.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;

public class CommandGiveHearts implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args){
        if(args.length < 2){
            sender.sendMessage(ChatColor.RED + "Error: Invalid syntax. Usage: /givehealth <player> <amount>");
            return true;
        }
        if(Bukkit.getPlayer(args[0]) == null){
            sender.sendMessage(ChatColor.RED + "Error: Player not found.");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        Double health = Double.valueOf(args[1]);
        if(health <= 0){
            sender.sendMessage(ChatColor.RED + "Error: Please specify a health value larger then 0.");
            return true;
        }
        Player player = (Player) sender;
        double senderhp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        double targethp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        if((senderhp - health) <= 1){
            sender.sendMessage(ChatColor.RED + "Error: Cannot give more health then you have.");
            return true;
        }
        target.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(targethp + health);
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(senderhp - health);
        sender.sendMessage(ChatColor.GRAY + "You have given " + target.getName() + " " + health.toString() + " HP");
        return true;
    }
}

