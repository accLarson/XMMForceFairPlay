package dev.zerek.XMMForceFairPlay.managers;

import dev.zerek.XMMForceFairPlay.XMMForceFairPlay;

/**
 * Manages the fair-play mode configuration and string generation.
 */
public class ModeManager {

    private final XMMForceFairPlay plugin;
    private final String string;
    private final String mode;

    /**
     * Creates a new mode manager.
     * @param plugin the plugin instance
     * @param mode the mode string from config
     */
    public ModeManager( XMMForceFairPlay plugin, String mode) {
        this.plugin = plugin;
        this.mode = mode.toUpperCase();
        this.string = determineString(this.mode);
    }
    
    /**
     * Determines the packet string based on the mode.
     * @param mode the mode to convert
     * @return the packet string or null
     */
    private String determineString(String mode) {
        return switch (mode) {
            case "FAIR-PLAY" -> "§f§a§i§r§x§a§e§r§o";
            case "FAIR-PLAY-NETHER" -> "§f§a§i§r§x§a§e§r§o§x§a§e§r§o§w§m§n§e§t§h§e§r§i§s§f§a§i§r";
            case "FULL-DISABLE" -> "§n§o§m§i§n§i§m§a§p";
            case "NONE" -> null;
            default -> {
                plugin.getLogger().warning("WARNING: Invalid mode '" + mode + "' specified in config.");
                yield null;
            }
        };
    }
    
    /**
     * Gets the packet string for the current mode.
     * @return the packet string
     */
    public String getString() {
        return this.string;
    }
    
    /**
     * Gets the current mode name.
     * @return the mode name
     */
    public String getMode() {
        return this.mode;
    }
}
