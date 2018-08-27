package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class HackersPlugin extends JavaPlugin {
    public static final Logger LOG = Logger.getLogger(HackersPlugin.class.getName());

    @Override
    public void onEnable() {
        getLogger().info("Loading Hackers plugin...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("zombie")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location playerLocation = player.getLocation();
                final Location zombieLocation = new Location(player.getWorld(),
                        playerLocation.getX() + 5,
                        playerLocation.getY(),
                        playerLocation.getZ());
                Zombie zombie = player.getWorld().spawn(zombieLocation, Zombie.class);
                player.sendMessage("Zombie near you!");
                LOG.info("Zombie spawned");
                return true;
            }
        } else if (label.equalsIgnoreCase("chickens")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location playerLocation = player.getLocation();
                for (int i = 0; i < 5; i++) {
                    final Location chickenLocation = new Location(player.getWorld(),
                            playerLocation.getX() + 5,
                            playerLocation.getY() + i,
                            playerLocation.getZ());
                    Chicken chicken = player.getWorld().spawn(chickenLocation, Chicken.class);
                }
                player.sendMessage("Chickens near you!");
                LOG.info("Chickens spawned");
                return true;
            }
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
}
