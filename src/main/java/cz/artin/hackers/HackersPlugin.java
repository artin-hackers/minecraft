package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.logging.Logger;

public class HackersPlugin extends JavaPlugin {
    private static final Logger LOG = Logger.getLogger(HackersPlugin.class.getName());
    private Location LAST_LOCATION;

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
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("Pickaxe of Dead");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        } else if (label.equalsIgnoreCase("equipShovel")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.DIAMOND_SHOVEL, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("Shovel of Earth");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        } else if (label.equalsIgnoreCase("equipSword")) {
            LOG.info("Error: Sword of Virtue is not implemented yet!");
            return true;
        } else if (label.equalsIgnoreCase("setCasual")) {
            return setCasual(sender);
        } else if (label.equalsIgnoreCase("setNighmare")) {
            return setNightmare(sender);
        } else if (label.equalsIgnoreCase("spawnZombie")) {
            Spawns spawns = new Spawns();
            return spawns.spawnZombie(sender);
        } else if (label.equalsIgnoreCase("spawnChickens")) {
            Spawns spawns = new Spawns();
            return spawns.spawnChickens(sender);
        } else if (label.equalsIgnoreCase("teleportTo")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                LAST_LOCATION = player.getLocation().clone();
                Location target_location = new Location(player.getWorld(), 100, 100, 100);
                player.teleport(target_location);
            }
        } else if (label.equalsIgnoreCase("teleportBack")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.teleport(LAST_LOCATION);
            }
        } else if (label.equalsIgnoreCase("becomeGhostRider")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                ItemStack fishingRod = new ItemStack(Material.FISHING_ROD, 1);
                ItemMeta meta = fishingRod.getItemMeta();
                meta.setDisplayName("Ghost Rider's fishing rod");
                fishingRod.setItemMeta(meta);
                player.getInventory().addItem(fishingRod);
                return true;
            }
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
}
