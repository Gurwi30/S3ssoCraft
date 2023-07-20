package me.gurwi.s3ssocraft.listeners;

import me.gurwi.s3ssocraft.S3ssoCraft;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ListenersManager {

    private final S3ssoCraft plugin;

    public ListenersManager(S3ssoCraft plugin) {
        this.plugin = plugin;

        register(new AnalKill());
        register(new AnalDeath());
    }

    private void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

}
