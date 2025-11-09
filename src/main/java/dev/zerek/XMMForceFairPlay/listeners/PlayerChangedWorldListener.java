package dev.zerek.XMMForceFairPlay.listeners;

import dev.zerek.XMMForceFairPlay.XMMForceFairPlay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

/**
 * Listens for player change world events to send fair-play packets.
 */
public class PlayerChangedWorldListener implements Listener {

    private final XMMForceFairPlay plugin;

    /**
     * Creates a new player change world listener.
     * @param plugin the plugin instance
     */
    public PlayerChangedWorldListener(XMMForceFairPlay plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles player change world events.
     * Sends fair-play packet to players without bypass permission.
     * @param event the player change world event
     */
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {

        if (event.getPlayer().hasPermission("fairplay.bypass")) return;

        String string = plugin.getModeManager().getString();

        if (string != null) {
            plugin.getServer().getScheduler().runTaskLater(plugin, () ->
                    plugin.getPacketManager().sendString(event.getPlayer(), string), 10L);
        }



    }
}
