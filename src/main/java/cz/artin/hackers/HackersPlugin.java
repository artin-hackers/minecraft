package cz.artin.hackers;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class HackersPlugin extends JavaPlugin {
    public static final Logger LOG = Logger.getLogger(HackersPlugin.class.getName());

    @Override
    public void onEnable() {
        getLogger().info("Loading Hackers plugin... jakub");
        getServer().getPluginManager().registerEvents(new MagicListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("zombie")) {
            if (sender instanceof Player) {
                spawnZombie((Player) sender);
                return true;
            }
        } else if (label.equalsIgnoreCase("chicken")) {
            if (sender instanceof Player) {
                spawnChicken((Player) sender);
                return true;
            }
        }else if(label.equalsIgnoreCase("firewand")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.STICK, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("Wand of Fire");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }else if(label.equalsIgnoreCase("firewand")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.STICK, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("Wand of Fire");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }else if (label.equalsIgnoreCase("house")) {
            if (sender instanceof Player) {
                    Player player = (Player) sender;
                    final Location playerLocation = player.getLocation();
                    House house = new House(playerLocation);
                    house.buildHouse();
                    return true;
            }
        }
        return false;
    }




    void spawnZombie(Player player) {
        final Location playerLocation = player.getLocation();
        final Location zombieLocation = new Location(player.getWorld(),
                playerLocation.getX() + 5, playerLocation.getY(), playerLocation.getZ());
        Zombie zombie = player.getWorld().spawn(zombieLocation, Zombie.class);
        player.sendMessage("Zombie near you!");
        LOG.info("Zombie spawned");
    }
    void spawnChicken (Player player) {
        final Location playerLocation = player.getLocation();
        final Location chickenLocation = new Location(player.getWorld(),
                playerLocation.getX() + 5,
                playerLocation.getY(),
                playerLocation.getZ());
        Chicken chicken = player.getWorld().spawn(chickenLocation, Chicken.class);
        player.sendMessage("Chicken near you!");
        LOG.info("Chicken spawned");
    }
}