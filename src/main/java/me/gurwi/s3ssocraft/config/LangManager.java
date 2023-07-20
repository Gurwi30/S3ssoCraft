package me.gurwi.s3ssocraft.config;

import me.gurwi.s3ssocraft.utils.PluginCustomLoader;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.Configuration;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public enum LangManager {

    PREFIX("Prefix"),
    NO_PERMS("No-Perms"),

    DEATH_MESSAGE("Death-Message");

    // CONSTRUCTOR

    public final String path;

    LangManager(String path) {
        this.path = path;
    }

    ///

    private final Configuration langConfig = PluginCustomLoader.getInstance().getConfigHandler().getLangConfig().getCustomConfig();

    // METHODS

    public List<String> getStringList() {
        return langConfig.getStringList(this.path);
    }
    public String getFormattedString() {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(langConfig.getString(this.path)));
    }
    public String getString() {
        return langConfig.getString(this.path);
    }
    public Boolean getBoolean() {
        return langConfig.getBoolean(this.path);
    }
    public Integer getInt() {
        return langConfig.getInt(this.path);
    }
    public Double getDouble() {
        return langConfig.getDouble(this.path);
    }
    public Long getLong() {
        return langConfig.getLong(this.path);
    }

}
