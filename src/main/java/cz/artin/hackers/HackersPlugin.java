package cz.artin.hackers;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.java.JavaPlugin;

import javax.swing.text.Position;
import java.util.logging.Logger;


public class HackersPlugin extends JavaPlugin {
    public static final Logger LOG = Logger.getLogger(HackersPlugin.class.getName());

    @Override
    public void onEnable() {
        getLogger().info("Loading Hackers plugin... xvojta");
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
        } else if (label.equalsIgnoreCase("chicken")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location playerLocation = player.getLocation();
                final Location chickenLocation = new Location(player.getWorld(),
                        playerLocation.getX() + 5,
                        playerLocation.getY(),
                        playerLocation.getZ());
                Chicken chicken = player.getWorld().spawn(chickenLocation, Chicken.class);
                player.sendMessage("Chicken near you!");
                LOG.info("Chicken spawned");
                return true;
            }
        } else if (label.equalsIgnoreCase("chicken")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location playerLocation = player.getLocation();
                final Location chickenLocation = new Location(player.getWorld(),
                        playerLocation.getX() + 5,
                        playerLocation.getY(),
                        playerLocation.getZ());
                Chicken chicken = player.getWorld().spawn(chickenLocation, Chicken.class);
                player.sendMessage("Chicken near you!");
                LOG.info("Chicken spawned");
                return true;
            }

        } else if (label.equalsIgnoreCase("house")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location playerLocation = player.getLocation();
                buildFloor(playerLocation);
                buildRoof(playerLocation);
                playerLocation.add(-2, -1, 2);
                buildWallX(playerLocation);
                playerLocation.add(2, 0, -2);
                playerLocation.add(-2, 0, -2);
                buildWallX(playerLocation);
                buildWallZ(playerLocation);
                playerLocation.add(2, 0, 2);
                playerLocation.add(2, 0, -2);
                buildWallZ(playerLocation);
                playerLocation.add(-2, 1, 2);
                buildDoor(playerLocation);
                buildRoad(playerLocation);
                buildDecorations(playerLocation);


                return true;
    }
}
        return false;
    }

    void buildWallX(Location playerLocation) {
        playerLocation = playerLocation.clone();
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e < 5; e++) {
                playerLocation.add(e, i, 0);
                playerLocation.getBlock().setType(Material.DARK_OAK_WOOD);
                playerLocation.add(-e, -i, -0);
            }
        }
    }
    void buildWallZ(Location playerLocation) {
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e < 5; e++) {
                playerLocation.add(0, i, e);
                playerLocation.getBlock().setType(Material.DARK_OAK_WOOD);
                playerLocation.add(-0, -i, -e);
            }
        }
    }
    void buildRoof(Location playerLocation) {
        playerLocation = playerLocation.clone();

        playerLocation.add(-1, 4, -1);
        for (int i = 0; i < 4; i++) {
            for (int e = 0; e < 4; e++) {
                playerLocation.add(i, 0, e);
                playerLocation.getBlock().setType(Material.DARK_OAK_WOOD);
                playerLocation.add(-i, 0, -e);
            }
        }

    }
    void buildFloor(Location playerLocation) {
        playerLocation = playerLocation.clone();

        playerLocation.add(-1, -1, -1);
        for (int i = 0; i < 4; i++) {
            for (int e = 0; e < 4; e++) {
                playerLocation.add(i, 0, e);
                playerLocation.getBlock().setType(Material.DARK_OAK_WOOD);
                playerLocation.add(-i, 0, -e);
            }
        }

    }

    void buildDecorations (Location playerLocation) {
        playerLocation = playerLocation.clone();

        playerLocation.add(0,0,1);
        playerLocation.getBlock().setType(Material.CRAFTING_TABLE);

        playerLocation.add(1,0,0);
        playerLocation.getBlock().setType(Material.ANVIL);

        playerLocation.add(-2,0,0);
        playerLocation.getBlock().setType(Material.CHEST);

        playerLocation.add(0,0,-2);
        playerLocation.getBlock().setType(Material.FURNACE);

        playerLocation.add(1,0,0);
        playerLocation.getBlock().setType(Material.ENCHANTING_TABLE);

        playerLocation.add(1,0,0);
        playerLocation.getBlock().setType(Material.JUKEBOX);

        playerLocation.add(-1,1,1);
        playerLocation.add(0,0,2);
        playerLocation.getBlock().setType(Material.GLASS);
        playerLocation.add(0,0,-4);
        playerLocation.getBlock().setType(Material.GLASS);
    }
    void buildRoad (Location playerLocation) {
        playerLocation = playerLocation.clone();

        playerLocation.add(3,0,1);
        for(int c = 0; c < 6; c++) {
            playerLocation.add(c, 0, 0);
            playerLocation.getBlock().setType(Material.POPPY);
            playerLocation.add(-c,0,0);
        }
        playerLocation.add(0,0,-2);
        for(int c = 0; c < 6; c++) {
            playerLocation.add(c, 0, 0);
            playerLocation.getBlock().setType(Material.POPPY);
            playerLocation.add(-c,0,0);
        }
        playerLocation.add(0,-1,1);
        for(int c = 0; c < 6; c++) {
            playerLocation.add(c, 0, 0);
            playerLocation.getBlock().setType(Material.STONE_BRICKS);
            playerLocation.add(-c,0,0);
        }

    }
    void buildDoor (Location playerLocation) {
        playerLocation = playerLocation.clone();

        playerLocation.add(2, 0, 0);
        playerLocation.getBlock().setType(Material.AIR);
        playerLocation.add(0, 1, 0);
        playerLocation.getBlock().setType(Material.DARK_OAK_TRAPDOOR);
    }

}