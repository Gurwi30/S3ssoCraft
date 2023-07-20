package me.gurwi.s3ssocraft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class AnalDeath implements Listener {

    @EventHandler
    public void onAnalDeath(PlayerDeathEvent event) {

        Player player = event.getEntity().getPlayer();
        Player killer = event.getEntity().getKiller();

        AnalKill.getSexCounter().remove(player.getUniqueId());
        AnalKill.getSexCounter().remove(killer.getUniqueId());

    }

}
