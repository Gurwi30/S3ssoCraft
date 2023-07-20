package me.gurwi.s3ssocraft.listeners;

import lombok.Getter;
import me.gurwi.s3ssocraft.config.LangManager;
import me.gurwi.s3ssocraft.objects.SexOffender;
import me.gurwi.s3ssocraft.utils.BasicFunctions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AnalKill implements Listener {

    @Getter
    private static final Map<UUID, SexOffender> sexCounter = new HashMap<>();

    @EventHandler
    public void onShift(PlayerToggleSneakEvent event) {

        Player player = event.getPlayer();
        if (!player.isSneaking()) return;

        player.getNearbyEntities(1, 1, 1).stream().filter(entity -> entity instanceof Player).forEach(nearbyPlayer -> {
            Player target = (Player) nearbyPlayer;

            if (!BasicFunctions.isBehind(player, target)) return;

            if (!sexCounter.containsKey(player.getUniqueId())) {
                int requiredCocks = BasicFunctions.getRequiredPenetrations();
                sexCounter.put(player.getUniqueId(), new SexOffender(target.getUniqueId(), requiredCocks));
            }

            SexOffender sexOffender = sexCounter.get(player.getUniqueId());

            if (sexOffender.getCurrentInculations() >= sexOffender.getRequiredInculations()) {
                target.setHealth(0);
                sexCounter.remove(player.getUniqueId());

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {

                    onlinePlayer.sendMessage(LangManager.DEATH_MESSAGE.getFormattedString()
                            .replace("%killer%", player.getName())
                            .replace("%victim%", target.getName()));

                }

            }

            sexOffender.incrementInculations();

        });

    }

}
