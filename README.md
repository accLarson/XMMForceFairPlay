# XMMForceFairPlay

**Server-enforced Xaero's Minimap fair-play mode.**

A lightweight plugin that uses [PacketEvents](https://www.spigotmc.org/resources/packetevents-api.80279/) to send invisible system-chat messages which [Xaero's Minimap](https://modrinth.com/mod/xaeros-minimap) interprets as client rules — disabling radar, cave mode, or the minimap entirely, with no client-side configuration required.

> **This is NOT an official project by Xaero.**

The screenshots below show client settings being forced **OFF** by the plugin:

![Forced client settings](https://i.imgur.com/3IanQcV.png)
![Forced client settings](https://i.imgur.com/ng7lDNq.png)

## Requirements

- Spigot / Paper / fork **1.21+**
- [PacketEvents](https://www.spigotmc.org/resources/packetevents-api.80279/) plugin

## Installation

1. Drop `XMMForceFairPlay-<version>.jar` into your `plugins/` folder alongside PacketEvents
2. Start the server once to generate `plugins/XMMForceFairPlay/config.yml`
3. Set `MODE` to taste and restart

## Modes

| Mode               | Behavior                                      |
| ------------------ | --------------------------------------------- |
| `FAIR-PLAY`        | No radar, no cave mode                        |
| `FAIR-PLAY-NETHER` | `FAIR-PLAY` + cave mode allowed in the Nether |
| `FULL-DISABLE`     | Minimap fully disabled                        |
| `NONE`             | Does nothing (no need to run the plugin)      |

## Default Config

```yaml
# XMMForceFairPlay Configuration
# Made by Zerek - Assistance from satadrive420
# https://github.com/accLarson
# Not an official Xaero project

# Available modes:
#   FAIR-PLAY: Disables cave mode and entity radar (fair-play mode) - Default
#   FAIR-PLAY-NETHER: Fair-play mode but allows cave mode in the nether
#   FULL-DISABLE: Completely disables the minimap
#   NONE: Does not enforce any restrictions (plugin does nothing)

MODE: "FAIR-PLAY"
```

## Permissions

| Node              | Default | Description                                    |
| ----------------- | ------- | ---------------------------------------------- |
| `fairplay.bypass` | `false` | Players with this permission are not affected |

## Folia

Folia is supported — the plugin uses entity-scheduled tasks rather than the global scheduler. Folia support was contributed by [@thepixel3261](https://github.com/thepixel3261).

## Support

Open an [issue on GitHub](https://github.com/accLarson/XMMForceFairPlay/issues) or message **Zerek** on Discord.