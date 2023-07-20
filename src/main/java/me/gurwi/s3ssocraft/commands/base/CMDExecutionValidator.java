package me.gurwi.fadedmask.commands.base;

import me.gurwi.fadedmask.config.LangManager;
import me.gurwi.fadedmask.utils.PermissionChecker;
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
