package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.logging.Logger;

public class Listener implements org.bukkit.event.Listener {
    public static final Logger LOG = Logger.getLogger(HackersPlugin.class.getName());

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location loc = event.getFrom();

        loc.add(0,-1,0);
        loc.getBlock().setType(Material.STONE_BRICKS);
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        LOG.info("Hello!");
    }
}
