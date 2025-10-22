package dev.zerek.XMMForceFairPlay;

import dev.zerek.XMMForceFairPlay.listeners.PlayerJoinListener;
import dev.zerek.XMMForceFairPlay.managers.ModeManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class XMMForceFairPlay extends JavaPlugin {

    private ModeManager modeManager;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        String mode = this.getConfig().getString("MODE", "FAIR-PLAY");
        modeManager = new ModeManager(this, mode);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getLogger().info("XMMForceFairPlay enabled with mode: " + modeManager.getMode());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ModeManager getModeManager() {
        return modeManager;
    }
}
