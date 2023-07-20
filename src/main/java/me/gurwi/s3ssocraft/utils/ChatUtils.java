package me.gurwi.vpenhancer.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ChatUtils {

    public static BaseComponent[] sendButtonMessage(String message, String button, ClickEvent.Action action, String value, String hoverText) {

        return new ComponentBuilder(message)
                .append(button)
                .event(new ClickEvent(action, value) )
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hoverText)))
                .create();

    }

    public static String getFormattedString(String string) {
        return ChatColor.translateAlternateColorCodes('&', "§f" + string);
    }

    public static List<String> getFormattedListString(List<String> list) {
        List<String> formattedList = new ArrayList<>();
        list.forEach(s -> formattedList.add(getFormattedString(s)));

        return formattedList;
    }

}
