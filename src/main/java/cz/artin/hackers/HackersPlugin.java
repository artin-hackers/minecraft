package cz.artin.hackers;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.logging.Logger;


public class HackersPlugin extends JavaPlugin implements org.bukkit.event.Listener {
    public static final Logger LOG = Logger.getLogger(HackersPlugin.class.getName());

    @Override
    public void onEnable() {
        getLogger().info("Loading Hackers plugin... xvojta");
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this, this);
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
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("Fireball gun");
        gunMeta.setDisplayName("Gun");
        gunMeta.setLore(lore);
        gun.setItemMeta(gunMeta);
        pl.getInventory().addItem(gun);
    }

    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event) {
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

            Player player = event.getPlayer();
            ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta() ;
            LOG.info(player.getHealth() + "");
            if(itemMeta.getDisplayName().equalsIgnoreCase("gun") && itemMeta.getLore().get(0).equals("Fireball gun")) {
                LOG.info("Fireball 5");
                Location loc = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(2)).toLocation(player.getWorld(), player.getLocation().getYaw(), player.getLocation().getPitch());
                Fireball fireball = player.getWorld().spawn(loc, Fireball.class);
            }
        }
    }

    @EventHandler
    public void scoreboard(PlayerJoinEvent e) {
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();

        Objective objective = sb.getObjective("showhealth");
        if(sb.getObjective("showhealth") == null) {
            objective = sb.registerNewObjective("showhealth", "health");
        }

        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective.setDisplayName(ChatColor.RED + "\u2764");

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.setScoreboard(sb);
            online.setHealth(online.getHealth());
        }
    }

}