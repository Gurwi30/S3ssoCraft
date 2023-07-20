package me.gurwi.s3ssocraft.utils;

import me.gurwi.s3ssocraft.config.ConfigManager;
import me.gurwi.s3ssocraft.utils.customlogger.CustomLogger;
import me.gurwi.s3ssocraft.utils.customlogger.LoggerTag;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Random;

public class BasicFunctions {

    public static boolean isBehind(Player player, Player target) {

        Location playerEyeLocation = player.getEyeLocation();
        Location targetEyeLocation = target.getEyeLocation();

        Vector c = targetEyeLocation.toVector().subtract(playerEyeLocation.toVector());
        Vector d = playerEyeLocation.getDirection();
        double delta = c.dot(d);
        return delta > 0;

    }

    public static int getRequiredPenetrations() {

        String rawValue = ConfigManager.REQUIRED_PENETRATIONS.getString();
        String randomRegex = "^RANDOM:\\d+:\\d+$";

        if (rawValue.matches(randomRegex)) {

            String[] randomOptionValue = rawValue.split(":");
            return generateRandomInt(Integer.parseInt(randomOptionValue[1]), Integer.parseInt(randomOptionValue[2]));

        } else if (isInt(rawValue)) {
            return Integer.parseInt(rawValue);

        } else {
            CustomLogger.log(LoggerTag.ERROR_TAG, "Invalid penetration amount value! Using the default one.");
            return generateRandomInt(1, 4);
        }

    }

    private static int generateRandomInt(Integer rangeMin, Integer rangeMax) {

        Random rand = new Random();
        return rand.nextInt(rangeMax - rangeMin + 1) + rangeMin;

    }

    private static boolean isInt(String string) {

        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
