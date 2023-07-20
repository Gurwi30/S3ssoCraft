package me.gurwi.s3ssocraft.commands.subcommands;

import me.gurwi.s3ssocraft.commands.base.SubCommand;
import me.gurwi.s3ssocraft.config.ConfigHandler;
import me.gurwi.s3ssocraft.config.LangManager;
import me.gurwi.s3ssocraft.utils.PluginCustomLoader;
import me.gurwi.s3ssocraft.utils.customlogger.CustomLogger;
import me.gurwi.s3ssocraft.utils.customlogger.LoggerTag;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends SubCommand {

    public ReloadCommand() {
        super("reload", "Reload the plugin configis", "sexcraft.reload", false);
    }

    private final ConfigHandler configHandler = PluginCustomLoader.getInstance().getConfigHandler();

    @Override
    public void execute(CommandSender sender, String[] args) {

        String prefix = LangManager.PREFIX.getFormattedString();
        long start = System.currentTimeMillis();

        CustomLogger.log(LoggerTag.INFO_TAG, "Started plugin reload...");
        sender.sendMessage(prefix + "§7Started plugin reload...");

        sender.sendMessage(prefix + "§7Reloading §fS3xCraft §7configurations...");
        configHandler.reloadConfigs();

        long elapsedTime = System.currentTimeMillis() - start;
        sender.sendMessage(prefix + "§7Reload finished in §d" + elapsedTime + "ms");
        CustomLogger.log(LoggerTag.SUCCESS_TAG, "Reload finished in §f" + elapsedTime + "ms");

    }

}
