package me.gurwi.fadedmask.utils;

import me.gurwi.fadedmask.config.LangManager;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionAttachmentInfo;

@SuppressWarnings("unused")
public class PermissionChecker {

    public static boolean playerHasPermissionStartingWith(CommandSender sender, String startsWith) {

        if (isOp(sender)) return true;

        for (PermissionAttachmentInfo permission : sender.getEffectivePermissions()) {
            if (permission.getPermission().startsWith(startsWith) && permission.getValue()) {
                return true;
            }
        }

        return false;

    }

    public static boolean isOp(CommandSender sender) {
        if (sender.isOp()) return true;
        if (sender.hasPermission("*")) return true;
        return sender.hasPermission("fadedmasks.*");
    }

    public static String getInsufficentPermsError() {
        String prefix = LangManager.PREFIX.getFormattedString();
        return prefix + LangManager.NO_PERMS.getFormattedString();
    }

}
