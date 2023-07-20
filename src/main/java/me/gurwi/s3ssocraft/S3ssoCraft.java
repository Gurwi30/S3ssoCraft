package me.gurwi.s3ssocraft;

import lombok.Getter;
import me.gurwi.s3ssocraft.utils.PluginCustomLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class S3ssoCraft extends JavaPlugin {

    @Getter
    private static S3ssoCraft instance;

    @Override
    public void onEnable() {
        instance = this;
        PluginCustomLoader.getInstance().loadPlugin();

    }

    @Override
    public void onDisable() {
        PluginCustomLoader.getInstance().disablePlugin();
    }
}
