package org.plaxerstudios.it.plaxerhub.Register;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;

import java.io.File;

public class RegisterConfig {
    private static Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);
    public static void registerConfig(){

        plugin.
        getConfig().options().copyDefaults(true);

        plugin.
        saveConfig();

        File configFile = new File(plugin.getDataFolder(), "PlaxerHubBlock.yml");
        if (!configFile.exists()) {
            // crea il file config.yml
            plugin.getLogger().info("Creazione del file coral.yml...");
            plugin.saveResource("PlaxerHubBlock.yml", false);

        }

        // carica la configurazione del plugin
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        config.options().copyDefaults(true);
        plugin.saveConfig();

    }

}
