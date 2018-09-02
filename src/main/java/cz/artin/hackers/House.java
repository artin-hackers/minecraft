package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class House {
    public boolean create(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            final Location playerLocation = player.getLocation();
            // Floor
            for (int i = -5; i <= 5; i++) {
                for (int j = -5; j <= 5; j++) {
                    final Location blockLocation = new Location(player.getWorld(),
                            playerLocation.getX() + i,
                            playerLocation.getY() - 1,
                            playerLocation.getZ() + j);
                    blockLocation.getBlock().setType(Material.STONE);
                }
            }
            // Walls
            for (int i = -5; i <= 5; i++) {
                for (int j = 0; j < 4; j++) {
                    final Location blockLocation = new Location(player.getWorld(),
                            playerLocation.getX() - 5,
                            playerLocation.getY() + j,
                            playerLocation.getZ() + i);
                    blockLocation.getBlock().setType(Material.GLASS);
                }
            }
            for (int i = -5; i <= 5; i++) {
                for (int j = 0; j < 4; j++) {
                    final Location blockLocation = new Location(player.getWorld(),
                            playerLocation.getX() + 5,
                            playerLocation.getY() + j,
                            playerLocation.getZ() + i);
                    blockLocation.getBlock().setType(Material.GLASS);
                }
            }
            for (int i = -5; i <= 5; i++) {
                for (int j = 0; j < 4; j++) {
                    final Location blockLocation = new Location(player.getWorld(),
                            playerLocation.getX() - i,
                            playerLocation.getY() + j,
                            playerLocation.getZ() - 5);
                    blockLocation.getBlock().setType(Material.GLASS);
                }
            }
            for (int i = -5; i <= 5; i++) {
                for (int j = 0; j < 4; j++) {
                    final Location blockLocation = new Location(player.getWorld(),
                            playerLocation.getX() - i,
                            playerLocation.getY() + j,
                            playerLocation.getZ() + 5);
                    blockLocation.getBlock().setType(Material.GLASS);
                }
            }
            // Ceiling
            for (int i = -5; i <= 5; i++) {
                for (int j = -5; j <= 5; j++) {
                    final Location blockLocation = new Location(player.getWorld(),
                            playerLocation.getX() + i,
                            playerLocation.getY() + 4,
                            playerLocation.getZ() + j);
                    blockLocation.getBlock().setType(Material.GLASS);
                }
            }
            // Entrance
            double rotation = (player.getLocation().getYaw() - 90) % 360;
            if (rotation < 0) {
                rotation += 360.0;
            }
            if (rotation >= 45 && rotation < 135) {
                player.sendMessage("North");
                final Location blockLocation = new Location(player.getWorld(),
                        playerLocation.getX(),
                        playerLocation.getY(),
                        playerLocation.getZ() - 5);
                blockLocation.getBlock().setType(Material.AIR);
                blockLocation.add(0, 1, 0);
                blockLocation.getBlock().setType(Material.AIR);
                blockLocation.add(0, -1, 0);
                blockLocation.getBlock().setType(Material.OAK_DOOR);
                blockLocation.add(0, 1, 0);
                blockLocation.getBlock().setType(Material.OAK_DOOR);
            } else if (rotation >= 135 && rotation < 225) {
                player.sendMessage("East");
                final Location blockLocation = new Location(player.getWorld(),
                        playerLocation.getX() + 5,
                        playerLocation.getY(),
                        playerLocation.getZ());
                blockLocation.getBlock().setType(Material.AIR);
                blockLocation.add(0, +1, 0);
                blockLocation.getBlock().setType(Material.AIR);
            } else if (rotation >= 225 && rotation < 315) {
                player.sendMessage("South");
                final Location blockLocation = new Location(player.getWorld(),
                        playerLocation.getX(),
                        playerLocation.getY(),
                        playerLocation.getZ() + 5);
                blockLocation.getBlock().setType(Material.AIR);
                blockLocation.add(0, +1, 0);
                blockLocation.getBlock().setType(Material.AIR);
            } else {
                player.sendMessage("West");
                final Location blockLocation = new Location(player.getWorld(),
                        playerLocation.getX() - 5,
                        playerLocation.getY(),
                        playerLocation.getZ());
                blockLocation.getBlock().setType(Material.AIR);
                blockLocation.add(0, +1, 0);
                blockLocation.getBlock().setType(Material.AIR);
            }
        }
        return true;
    }
}
