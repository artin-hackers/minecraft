package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
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
        }

        return false;
    }
}
