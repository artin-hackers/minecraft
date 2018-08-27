package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class HackersPlugin extends JavaPlugin {
    private static final Logger LOG = Logger.getLogger(HackersPlugin.class.getName());
    private enum directions {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    @Override
    public void onEnable() {
        getLogger().info("Loading Hackers plugin...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("spawnZombie")) {
            return spawnZombie(sender);
        } else if (label.equalsIgnoreCase("spawnChickens")) {
            return spawnChickens(sender);
        } else if (label.equalsIgnoreCase("water")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location playerLocation = player.getLocation();
                playerLocation.add(0, -1, 0);
                playerLocation.getBlock().setType(Material.WATER);
                player.sendMessage("Water!");
                LOG.info("Creating water");
            }
        } else if (label.equalsIgnoreCase("house")) {
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
                player.sendMessage("Look! A house.");
                LOG.info("Creating a house");
            }
        } else if (label.equalsIgnoreCase("day")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                for (World world : this.getServer().getWorlds()) {
                    world.setStorm(false);
                    if (world.getTime() >= 13000) {
                        world.setTime(0);
                    }
                }
                player.sendMessage("New day!");
                LOG.info("Setting day");
            }
        } else if (label.equalsIgnoreCase("plain")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location playerLocation = player.getLocation();
                for (int x = -20; x <= 20; x++) {
                    for (int y = 0; y <= 10; y++) {
                        for (int z = -20; z <= 20; z++) {
                            final Location blockLocation = new Location(player.getWorld(),
                                    playerLocation.getX() + x,
                                    playerLocation.getY() + y,
                                    playerLocation.getZ() + z);
                            blockLocation.getBlock().setType(Material.AIR);
                        }
                    }
                }
                player.sendMessage("Destroyer!");
                LOG.info("Creating a plain");
            }
        }

        return false;
    }

    private directions getDirection(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int rotation = Math.round(player.getLocation().getYaw() + 270) % 360;
            if (rotation >= 45 && rotation < 135) {
                return directions.NORTH;
            } else if (rotation >= 135 && rotation < 225) {
                return directions.EAST;
            } else if (rotation >= 225 && rotation < 315) {
                return directions.SOUTH;
            } else {
                return directions.WEST;
            }
        }
        return null;
    }

    private Location putInView(CommandSender sender, int distance) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation().clone();
            directions direction = getDirection(sender);
            if (direction == directions.NORTH) {
                location.add(0, 0, -distance);
            } else if (direction == directions.EAST) {
                location.add(distance, 0, 0);
            } else if (direction == directions.SOUTH) {
                location.add(0, 0, distance);
            } else if (direction == directions.WEST) {
                location.add(-distance, 0, 0);
            } else {
                LOG.info("Error: putInView()");
                return null;
            }
            return location;
        }
        return null;
    }

    private boolean spawnChickens(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (int i = 0; i < 5; i++) {
                Location chickenLocation = putInView(sender, 4);
                chickenLocation.add(0, i, 0);
                Chicken chicken = player.getWorld().spawn(chickenLocation, Chicken.class);
            }
            return true;
        }
        return false;
    }

    private boolean spawnZombie(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location zombieLocation = putInView(sender, 5);
            Zombie zombie = player.getWorld().spawn(zombieLocation, Zombie.class);
            return true;
        }
        return false;
    }
}
