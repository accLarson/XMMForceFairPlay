package dev.zerek.XMMForceFairPlay.managers;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.manager.protocol.ProtocolManager;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSystemChatMessage;
import net.kyori.adventure.text.Component;
import dev.zerek.XMMForceFairPlay.XMMForceFairPlay;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.entity.Player;

/**
 * Manages packet sending using PacketEvents API.
 */
public class PacketManager {
    
    private final XMMForceFairPlay plugin;
    
    /**
     * Creates a new packet manager.
     * @param plugin the plugin instance
     */
    public PacketManager(XMMForceFairPlay plugin) {
        this.plugin = plugin;
    }
    
    /**
     * Loads the PacketEvents API.
     */
    public void load() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(plugin));
        PacketEvents.getAPI().load();
    }
    
    /**
     * Initializes the PacketEvents API.
     */
    public void init() {
        PacketEvents.getAPI().init();
    }
    
    /**
     * Terminates the PacketEvents API.
     */
    public void terminate() {
        PacketEvents.getAPI().terminate();
    }
    
    /**
     * Sends a string message to a player via packet.
     * @param player the player to send to
     * @param message the message to send
     */
    public void sendString(Player player, String message) {
        ProtocolManager protocolManager = PacketEvents.getAPI().getProtocolManager();
        WrapperPlayServerSystemChatMessage packet = new WrapperPlayServerSystemChatMessage(false, Component.text(message));
        protocolManager.sendPacketSilently(protocolManager.getChannel(player.getUniqueId()), packet);
    }
}
