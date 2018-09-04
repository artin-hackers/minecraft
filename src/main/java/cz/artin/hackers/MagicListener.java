package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class MagicListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
        if (itemInMainHand != null
                && itemInMainHand.getItemMeta() != null
                && itemInMainHand.getItemMeta().getDisplayName().equals("Shovel of Earth")) {
            Location positionFrom = event.getFrom();
            positionFrom.add(0, -1, 0);
            positionFrom.getBlock().setType(Material.DIRT);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
            if (itemInMainHand != null && itemInMainHand.getItemMeta() != null) {
                if (itemInMainHand.getItemMeta().getDisplayName().equals("Axe of Fire")) {
                    event.getPlayer().launchProjectile(Fireball.class);
                }
                else if (itemInMainHand.getItemMeta().getDisplayName().equals("Pickaxe of Dead")) {
                    Player player = event.getPlayer();
                    Spawns spawns = new Spawns();
                    spawns.spawnZombie(player);
                }
            }
        }
    }
}
