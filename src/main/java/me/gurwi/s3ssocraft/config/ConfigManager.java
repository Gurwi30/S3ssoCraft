package me.gurwi.s3ssocraft.config;

import me.gurwi.s3ssocraft.S3ssoCraft;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.Configuration;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public enum ConfigManager {

    REQUIRED_PENETRATIONS("Required-Penetrations");

    // CONSTRUCTOR

    public final String path;

    ConfigManager(String path) {
        this.path = path;
    }

    ///

    private final Configuration config = S3ssoCraft.getInstance().getConfig();

    // METHODS

    public List<String> getStringList() {
        return config.getStringList(this.path);
    }
    public String getFormattedString() {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getString(this.path)));
    }
    public String getString() {
        return config.getString(this.path);
    }
    public Boolean getBoolean() {
        return config.getBoolean(this.path);
    }
    public Integer getInt() {
        return config.getInt(this.path);
    }
    public Double getDouble() {
        return config.getDouble(this.path);
    }
    public Long getLong() {
        return config.getLong(this.path);
    }

}
