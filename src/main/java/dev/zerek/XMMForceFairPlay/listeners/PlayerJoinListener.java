package dev.zerek.XMMForceFairPlay.listeners;

import dev.zerek.XMMForceFairPlay.XMMForceFairPlay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final XMMForceFairPlay plugin;

    public PlayerJoinListener(XMMForceFairPlay plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (event.getPlayer().hasPermission("fairplay.bypass")) return;

        String controlString = plugin.getModeManager().getString();

        if (controlString != null) {
            String playerName = event.getPlayer().getName();
            String command = String.format("tellraw %s {\"text\":\"%s\"}", playerName, controlString);
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
        }
    }
}
