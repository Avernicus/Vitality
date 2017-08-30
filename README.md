# Vitality

Vitality is an alternative to essentials. Vitality is NOT a competitor of essentials. Not only has essentials been tested and developed for years, it is in almost everyone's go-to set of plugins to install first (including myself). Vitality is intended as an open path of development for features that may not be in essentials, including features that may need improvement in essentials. If you have any suggestions be sure to drop a [suggestion here](https://github.com/cyberpwnn/Vitality/issues).

Vitality is planned to support minecraft 1.2.5 and above. Since it is designed to work as an essential plugin, it needs to support really really old versions. The design is to have certain features work with only certain ranges of versions, and not limit feature development based on what is possible in all supported versions. By doing this, **it opens up a world of possibilities for newer versions without breaking the plugin on older versions.**

### [Download the latest beta build here](https://github.com/cyberpwnn/Vitality/releases)

## Commands
All of the commands are listed below in sections (sorted by related features). Please note that the commands listed below are **already implemented.** If you have a suggestion for a command or feature, please drop a [suggestion here](https://github.com/cyberpwnn/Vitality/issues).
* [Teleportation](https://github.com/cyberpwnn/Vitality/blob/master/README.md#teleportation)
* [Game Mode Switching](https://github.com/cyberpwnn/Vitality/blob/master/README.md#game-mode-switching)

### Teleportation
Teleportation commands are used for getting any amount of players to a destination. The purpose for "f" in commands noted as force is because **the normal teleport goal is NOT to teleport you exactly to the destination.** For example, using /tp cyberpwn will teleport you NEAR cyberpwn in a SAFE location, but not inside (at the same location as) cyberpwn. Using /tpf will force the exact location, ignoring saftey checks.

| Command | Usage |
|---|---|
| /tp <player> [other] | Teleports to a player (or teleports a to b) |
| /tpf <player> [other] | Forcefully teleports to a player (or teleports a to b) |
| /tphere <player> | Teleports a player to you |
| /tpfhere <player> | Forcefully teleports a player to you |
| /tpall | Teleports all players to you |
| /tpfall | Forcefully teleports all players to you |

### Game Mode Switching
Gamemode switching is pretty simple as it should be. However since vitality supports versions as low as 1.2.5, depending on what gamemode you want to switch to, it may reject you if your server does not have that game mode in the first place.

| Command | Usage |
|---|---|
| /gm <mode> [other] | Sets your gamemode to the given mode (or another player) |
| /gms [other] | Sets your gamemode to survival (or another player) |
| /gmc [other] | Sets your gamemode to creative (or another player) |
| /gma [other] | Sets your gamemode to adventure (or another player) |
| /gmsp [other] | Sets your gamemode to spectator (or another player) |

#### GameMode Qualifying Values 
The gamemode values used for ```/gm <mode> [other]```

| GameMode | Qualifying Values |
|---|---|
| Survival | "s" or "0" |
| Creative | "c" or "1" |
| Adventure | "a" or "2" |
| Spectator | "sp" or "3" |
