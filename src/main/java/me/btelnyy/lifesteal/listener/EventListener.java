package me.btelnyy.lifesteal.listener;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.btelnyy.lifesteal.constants.Globals;

public class EventListener implements Listener {
    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent event){
        if(event.getEntity().getKiller() == null){
            return;
        }
        Player deadPlayer = event.getEntity();
        Player killerPlayer = event.getEntity().getKiller();
        AttributeInstance deadmaxhp = deadPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        AttributeInstance killermaxhp = killerPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        double deadoldvalue = deadmaxhp.getValue();
        double killeroldvalue = killermaxhp.getValue();
        deadmaxhp.setBaseValue(deadoldvalue - Globals.heartsPunishment);
        killermaxhp.setBaseValue(killeroldvalue + Globals.heartsPunishment);
    }
}
