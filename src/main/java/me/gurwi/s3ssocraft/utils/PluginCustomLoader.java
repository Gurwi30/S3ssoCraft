package me.gurwi.s3ssocraft.utils;

import lombok.Getter;
import me.gurwi.s3ssocraft.S3ssoCraft;
import me.gurwi.s3ssocraft.commands.SEXMainCommand;
import me.gurwi.s3ssocraft.config.ConfigHandler;
import me.gurwi.s3ssocraft.listeners.ListenersManager;
import me.gurwi.s3ssocraft.utils.customlogger.CustomLogger;
import me.gurwi.s3ssocraft.utils.customlogger.LoggerTag;

public class PluginCustomLoader {

    @Getter(lazy = true)
    private static final PluginCustomLoader instance = new PluginCustomLoader();

    private final S3ssoCraft plugin = S3ssoCraft.getInstance();
    private final String pluginVersion = plugin.getDescription().getVersion();

    @Getter
    private ConfigHandler configHandler;

    // METHODS

    private void loadConfig() {
        CustomLogger.log(LoggerTag.LOAD_TAG, "Loading Config...");
        configHandler = new ConfigHandler(plugin);

        configHandler.loadConfigs();
    }

    private void loadListeners() {
        CustomLogger.log(LoggerTag.LOAD_TAG, "Loading Listeners...");

        new ListenersManager(plugin);
    }

    private void loadCommands() {
        CustomLogger.log(LoggerTag.LOAD_TAG, "Loading Commands...");

        plugin.getCommand("sessocraft").setExecutor(new SEXMainCommand());
    }

    private void loadTabCompleters() {

    }

    // MAIN METHODS

    public void loadPlugin() {

        loadConfig();

        loadListeners();
        loadCommands();
        loadTabCompleters();

    }

    public void disablePlugin() {

    }

}
