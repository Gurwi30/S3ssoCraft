package me.gurwi.s3ssocraft.commands.subcommands;

import me.gurwi.s3ssocraft.S3ssoCraft;
import me.gurwi.s3ssocraft.commands.base.SubCommand;
import org.bukkit.command.CommandSender;

public class VersionCommand extends SubCommand {

    public VersionCommand() {
        super("version", "Shows more informations about the plugin", null, false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        sender.sendMessage("");
        sender.sendMessage("    §7S3xCraft " + S3ssoCraft.getInstance().getDescription().getVersion());
        sender.sendMessage("    §7By @Gurwi30 (§f@FadedStudios§7)");
        sender.sendMessage("");

    }


}
