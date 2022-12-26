# Vault Mapper
This mod is intended to be used with the Vault Hunters Modpack. It uses the information typed in chat to create a map of your current vault. Ask your Vault Hunters server admin if you are allowed use this mod before using it. We do not consider it as cheating cheating because the same behavior could be acheived with a piece of graph paper, but their views may differ.

# Installation
To install this mod, simpily download the lastest version from [the releases page](https://github.com/EnderLord0042/VaultMapper/releases), and place it in the mods folder of your Vault Hunters Minecraft instance.

# Usage
When you enter a vault with this mod installed, a map will automatically appear in the top right corner of your screen. Certain messages in chat will update this map

## Map Features
 - Grey Tiles: Predicted Rooms (This will change as more of the vault is explored and certain possibilites are eliminated.)
 - White Tiles: Discovered Rooms
 - Green Dot: Portal Room
 - Red Dot: Player's Position
 - Black Lines: Walls

## Chat Controls
### Discovering Rooms
There are two ways to indicate that your player has moved to a new room. You can either type the last direction you moved in, or specify new relative coordinates of your player. In all chat controls, uppercase and lowercase do not matter.

##### Last Direction Moved
This is the simplest way to indicate that the player has moved to a new room. Simpily type "N", "E", "S", or "W" in the chat to indicate that you have moved North, South, East or West respectively.

##### Relative Coordinates
This method involves typing your coordinates in the vault relative to the portal room as you explore the vault. There are various combinations of numbers and letters supported. They are listed below with "D" indicating a direction, such as "N", "E", "S", or "W"; and "#" indicating a number. Negative numbers are not supported.

#D
D#
#D#D
D#D#

An example of what might be typed in chat as relative coordinates are used to map a vault is shown below

1N
2N
2N1W
1N1W
1W
1S1W
1S2W

### Discovering Walls
It is usually not necessary to specify walls discovered, but they can help with the vault shape prediction. Walls surrounding the portal room are discovered automatically based on the first direction used to exit the portal room. For other walls, they must be discovered by typing "wall" followed by all directions in which walls are present. An example is shown below

wall wne

# Credits
EnderLord0042 - Mod Idea & Creation

melonboy10 - Creating a ChatGPT readme that was bad and misleading that EnderLord0042 had to rewrite

# License
This mod is licensed under the MIT License. See LICENSE for more information.
