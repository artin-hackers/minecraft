package cz.artin.hackers;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

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
                spawnZombie((Player) sender);
                return true;
            }
        } else if (label.equalsIgnoreCase("chicken")) {
            if (sender instanceof Player) {
                spawnChicken((Player) sender);
                return true;
            }
        } else if (label.equalsIgnoreCase("house")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location playerLocation = player.getLocation();
                House house = new House(playerLocation);
                house.buildHouse();
                return true;
            }
        } else if (label.equalsIgnoreCase("gun")) {
            if (sender instanceof Player) {
                giveGunToPlayer((Player) sender);
            }
        }
        return false;
    }


    void spawnZombie(Player player) {
        final Location playerLocation = player.getLocation();
        final Location zombieLocation = new Location(player.getWorld(),
       playerLocation.getX() + 5,
        playerLocation.getY(),
        playerLocation.getZ());
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

    private void giveGunToPlayer(Player pl) {
        ItemStack gun = new ItemStack(Material.BLAZE_ROD);
        ItemMeta gunMeta = gun.getItemMeta();
        gunMeta.setDisplayName("Gun");
        gun.setItemMeta(gunMeta);
        pl.getInventory().addItem(gun);
    }

    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event) {
        LOG.info("Fireball");
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemMeta itemMeta = player.getItemOnCursor().getItemMeta();
            if(itemMeta.getDisplayName().equalsIgnoreCase("gun")) {
                Location loc = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(2)).toLocation(player.getWorld(), player.getLocation().getYaw(), player.getLocation().getPitch());
                Fireball fireball = player.getWorld().spawn(loc, Fireball.class);
            }
        }
    }

}