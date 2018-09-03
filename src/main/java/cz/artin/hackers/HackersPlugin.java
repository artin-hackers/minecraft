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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        getServer().getPluginManager().registerEvents(new MagicListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("createHouse")) {
            House house = new House();
            return house.create(sender);
        } else if (label.equalsIgnoreCase("createPlain")) {
            return createPlain(sender);
        } else if (label.equalsIgnoreCase("createPool")) {
            return createPool(sender);
        } else if (label.equalsIgnoreCase("equipAxe")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("Axe of Fire");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        } else if (label.equalsIgnoreCase("equipPickaxe")) {
            LOG.info("Error: Pickaxe of Death is not implemented yet!");
            return true;
        } else if (label.equalsIgnoreCase("equipShovel")) {
            LOG.info("Error: Shovel of Earth is not implemented yet!");
            return true;
        } else if (label.equalsIgnoreCase("equipSword")) {
            LOG.info("Error: Sword of Virtue is not implemented yet!");
            return true;
        } else if (label.equalsIgnoreCase("setCasual")) {
            return setCasual(sender);
        } else if (label.equalsIgnoreCase("setNighmare")) {
            return setNightmare(sender);
        } else if (label.equalsIgnoreCase("spawnZombie")) {
            return spawnZombie(sender);
        } else if (label.equalsIgnoreCase("spawnChickens")) {
            return spawnChickens(sender);
        }
        return false;
    }

    private boolean createPlain(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            final Location playerLocation = player.getLocation();
            for (int x = -10; x <= 10; x++) {
                for (int y = 0; y <= 10; y++) {
                    for (int z = -10; z <= 10; z++) {
                        final Location blockLocation = new Location(player.getWorld(),
                                playerLocation.getX() + x,
                                playerLocation.getY() + y,
                                playerLocation.getZ() + z);
                        blockLocation.getBlock().setType(Material.AIR);
                    }
                }
            }
        }
        return true;
    }

    private boolean createPool(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    Location waterLocation = player.getLocation().clone();
                    waterLocation.add(i, -1, j);
                    waterLocation.getBlock().setType(Material.WATER);
                }
            }
            return true;
        }
        return false;
    }

    private boolean setCasual(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (World world : this.getServer().getWorlds()) {
                world.setTime(1000);
                world.setStorm(false);
            }
        }
        return true;
    }

    private boolean setNightmare(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (World world : this.getServer().getWorlds()) {
                world.setTime(18000);
                world.setStorm(true);
            }
        }
        return true;
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

}
