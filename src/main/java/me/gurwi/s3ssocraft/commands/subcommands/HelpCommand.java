package me.gurwi.s3ssocraft.commands.subcommands;

import me.gurwi.s3ssocraft.S3ssoCraft;
import me.gurwi.s3ssocraft.commands.base.SubCommand;
import me.gurwi.s3ssocraft.utils.PluginCustomLoader;
import org.bukkit.command.CommandSender;

public class HelpCommand extends SubCommand {

    public HelpCommand() {
        super("help", "shows all the available commands", null, false);
    }

    private final PluginCustomLoader customLoader = PluginCustomLoader.getInstance();

    @Override
    public void execute(CommandSender sender, String[] args) {

        sender.sendMessage("");
        sender.sendMessage("§d§lS3xCraft §7Running on " + S3ssoCraft.getInstance().getDescription().getVersion());
        sender.sendMessage("");
        sender.sendMessage("§8• §7§nAvalaible Commands:");
        sender.sendMessage("    §f/sexcraft help §8‣ §7Shows the list of all the available commands");
        sender.sendMessage("    §f/sexcraft reload §8‣ §7Reload plugin configurations");
        sender.sendMessage("    §f/sexcraft version §8‣ §7Get current plugin version");
        sender.sendMessage("");

    }

}
