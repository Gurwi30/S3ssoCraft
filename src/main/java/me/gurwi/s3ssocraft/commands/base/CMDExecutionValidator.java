package me.gurwi.s3ssocraft.commands.base;

import me.gurwi.s3ssocraft.config.LangManager;
import me.gurwi.s3ssocraft.utils.PermissionChecker;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDExecutionValidator {

    public static boolean validate(SubCommand command, CommandSender sender) {

        String prefix = LangManager.PREFIX.getFormattedString();

        if (command.isPlayerOnly() && !(sender instanceof Player)) {
            sender.sendMessage(prefix + onlyPlayerError());
            return false;
        }

        if (command.getPermission() != null && !PermissionChecker.isOp(sender)) {
            sender.sendMessage(PermissionChecker.getInsufficentPermsError());
            return false;
        }

        return true;

    }

    public static String onlyPlayerError() {
        return "§c§oOnly players can execute this command!";
    }

}
