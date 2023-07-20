package me.gurwi.s3ssocraft.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.gurwi.s3ssocraft.S3ssoCraft;
import me.gurwi.s3ssocraft.glib.ResourceConfig;

@Getter
@RequiredArgsConstructor
public class ConfigHandler {

    private final S3ssoCraft plugin;
    private ResourceConfig langConfig;

    ///

    public void loadConfigs() {
        plugin.saveDefaultConfig();
        langConfig = new ResourceConfig(plugin, "lang.yml", false);
    }

    public void reloadConfigs() {
        plugin.reloadConfig();
        langConfig.reloadConfig();
    }

}
