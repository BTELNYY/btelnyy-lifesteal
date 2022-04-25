package me.btelnyy.lifesteal.service;

import me.btelnyy.lifesteal.constants.*;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class ConfigLoaderService {

    private final FileConfiguration config;
    private final Logger            logger;

    public ConfigLoaderService(FileConfiguration config, Logger logger) {
        this.config = config;
        this.logger = logger;
    }

    public void loadConfig() {
        Globals.heartsPunishment = config.getDouble("hp_taken_per_kill");
        logger.log(Level.INFO, "hp_taken_per_kill: " + Globals.heartsPunishment);
    }
}
