package dev.zerek.XMMForceFairPlay;

import dev.zerek.XMMForceFairPlay.listeners.PlayerJoinListener;
import dev.zerek.XMMForceFairPlay.managers.PacketManager;
import dev.zerek.XMMForceFairPlay.managers.ModeManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class XMMForceFairPlay extends JavaPlugin {

    private PacketManager packetManager;
    private ModeManager modeManager;

    @Override
    public void onLoad() {
        packetManager = new PacketManager(this);
        packetManager.load();
    }

    @Override
    public void onEnable() {

        saveDefaultConfig();
        String mode = this.getConfig().getString("MODE", "FAIR-PLAY");
        modeManager = new ModeManager(this, mode);

        packetManager.init();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getLogger().info("XMMForceFairPlay enabled with mode: " + modeManager.getMode());
    }

    @Override
    public void onDisable() {
        packetManager.terminate();
    }

    /**
     * Gets the mode manager instance.
     * @return the mode manager
     */
    public ModeManager getModeManager() {
        return modeManager;
    }
    
    /**
     * Gets the packet manager instance.
     * @return the packet manager
     */
    public PacketManager getPacketManager() {
        return packetManager;
    }

}
