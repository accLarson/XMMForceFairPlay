package dev.zerek.XMMForceFairPlay.listeners;

import dev.zerek.XMMForceFairPlay.XMMForceFairPlay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Listens for player join events to send fair-play packets.
 */
public class PlayerJoinListener implements Listener {

    private final XMMForceFairPlay plugin;

    /**
     * Creates a new player join listener.
     * @param plugin the plugin instance
     */
    public PlayerJoinListener(XMMForceFairPlay plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles player join events.
     * Sends fair-play packet to players without bypass permission.
     * @param event the player join event
     */
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (event.getPlayer().hasPermission("fairplay.bypass")) return;

        String string = plugin.getModeManager().getString();

        if (string != null) {
            plugin.getServer().getScheduler().runTaskLater(plugin, () ->
                    plugin.getPacketManager().sendString(event.getPlayer(), string), 10L);
        }
    }
}
