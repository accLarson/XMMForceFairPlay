package dev.zerek.XMMForceFairPlay.managers;

import dev.zerek.XMMForceFairPlay.XMMForceFairPlay;

public class ModeManager {

    private final XMMForceFairPlay plugin;
    private final String string;
    private final String mode;

    public ModeManager( XMMForceFairPlay plugin, String mode) {
        this.plugin = plugin;
        this.mode = mode.toUpperCase();
        this.string = determineString(this.mode);
    }
    
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
    
    public String getString() {
        return this.string;
    }
    
    public String getMode() {
        return this.mode;
    }
}
