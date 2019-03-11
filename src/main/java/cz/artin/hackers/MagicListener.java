package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class MagicListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
            if (itemInMainHand != null && itemInMainHand.getItemMeta() != null) {
                if (itemInMainHand.getItemMeta().getDisplayName().equals("filipovasekera")) {
                    event.getPlayer().launchProjectile(Fireball.class);
                }
                if (itemInMainHand.getItemMeta().getDisplayName().equals("magickykrumpac")) {
                    event.getPlayer().launchProjectile(Arrow.class);
                }
                if (itemInMainHand.getItemMeta().getDisplayName().equals("magickymec")) {
                    Player player = event.getPlayer();
                    Location kureLocation = player.getLocation().clone();
                    kureLocation.add(5, 0, 0);
                    Chicken kure = player.getWorld().spawn(kureLocation, Chicken.class);
                }
                if (itemInMainHand.getItemMeta().getDisplayName().equals("magickysip")) {
                    Player player = event.getPlayer();
                    Location kralikLocation = player.getLocation().clone();
                    kralikLocation.add(5, 0, 0);
                    Rabbit kralik = player.getWorld().spawn(kralikLocation, Rabbit.class);

                }
                if (itemInMainHand.getItemMeta().getDisplayName().equals("magickydiamantovymec")) {
                    Player player = event.getPlayer();
                    Location pozicevlka = player.getLocation().clone();
                    pozicevlka.add(5, 0, 0);
                    Wolf vlk = player.getWorld().spawn(pozicevlka, Wolf.class);

                }
                if (itemInMainHand.getItemMeta().getDisplayName().equals("zlatykrumpac")) {
                    Player player = event.getPlayer();
                    Location pozicepavouka = player.getLocation().clone();
                    pozicepavouka.add(5, 0, 0);
                    Spider pavouk = player.getWorld().spawn(pozicepavouka, Spider.class);

                }


                if (itemInMainHand.getItemMeta().getDisplayName().equals("magickalopata")) {
                    Player player = event.getPlayer();
                    Location zombikLocation = player.getLocation().clone();
                    zombikLocation.add(5, 0, 0);
                    Zombie zombik = player.getWorld().spawn(zombikLocation, Zombie.class);
                }
                if (itemInMainHand.getItemMeta().getDisplayName().equals("nicicilopata")) {
                    Player player = event.getPlayer();
                    final Location playerLocation = player.getLocation();
                    for (int x = -20; x <= 20; x++) {
                        for (int y = -20; y <= 20; y++) {
                            for (int z = -20; z <= 20; z++) {
                                final Location blockLocation = new Location(player.getWorld(),
                                        playerLocation.getX() + x,
                                        playerLocation.getY() + y,
                                        playerLocation.getZ() + z);
                                blockLocation.getBlock().setType(Material.AIR);
                            }

                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
        if (itemInMainHand != null && itemInMainHand.getItemMeta() != null) {
            if (itemInMainHand.getItemMeta().getDisplayName().equals("supermec")) {
             Location positionFrom = event.getFrom();
                positionFrom.getBlock().setType(Material.FIRE);
            }

        }
    }
}



