package me.gurwi.fadedmask.config;

import com.cryptomorin.xseries.XMaterial;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.gurwi.fadedmask.FadedMask;
import me.gurwi.fadedmask.cache.ItemsManager;
import me.gurwi.fadedmask.config.managers.MasksManager;
import me.gurwi.fadedmask.glib.ResourceConfig;
import me.gurwi.fadedmask.utils.itemstack.GItemStack;

@Getter
@RequiredArgsConstructor
public class ConfigHandler {

    private final FadedMask plugin;
    private ResourceConfig langConfig;
    private ResourceConfig masksConfig;

    private MasksManager masksManager;
    private final ItemsManager itemsManager = ItemsManager.getInstance();

    ///

    public void loadConfigs() {
        plugin.saveDefaultConfig();
        addDefaultItems();

        langConfig = new ResourceConfig(plugin, "lang.yml", false);
        masksConfig = new ResourceConfig(plugin, "masks.yml", false);

        masksManager = new MasksManager(masksConfig.getCustomConfig());
        masksManager.loadMasks();
    }

    public void reloadConfigs() {
        plugin.reloadConfig();
        addDefaultItems();

        langConfig.reloadConfig();
        masksConfig.reloadConfig();

        masksManager.loadMasks();
    }

    private void addDefaultItems() {
        itemsManager.removeAllItems();
        itemsManager.addItem("randommask", GItemStack.deserialize(plugin.getConfig().getConfigurationSection("Items.RandomMask"),
                XMaterial.PLAYER_HEAD,
                "FadeMask_Custom", "randomMask"));
    }

}
