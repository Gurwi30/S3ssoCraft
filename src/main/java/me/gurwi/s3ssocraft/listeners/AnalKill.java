package it.fademc.ffactions.listeners.sex;

import it.fademc.ffactions.utils.BasicsFunction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class ShiftKill implements Listener {

    @EventHandler
    public void onShift(PlayerToggleSneakEvent event) {

        Player player = event.getPlayer();

        player.getNearbyEntities(1, 1, 1).forEach(entity -> {
            if (!(entity instanceof Player)) return;
            Player target = (Player) entity;

            if (!BasicsFunction.isBehind(player, target)) return;

            target.setHealth(0);

        });

    }

}
