package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.plugin.java.JavaPlugin;

public class HackersPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hackers plugin se nacita...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("vlk")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location pozicevlka = player.getLocation().clone();
                pozicevlka.add(5, 0, 0);
                Wolf vlk = player.getWorld().spawn(pozicevlka, Wolf.class);

            }
            return true;
        }

        if (label.equalsIgnoreCase("kure")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location kureLocation = player.getLocation().clone();
                kureLocation.add(5, 0, 0);
                Chicken kure = player.getWorld().spawn(kureLocation, Chicken.class);

            }
            return true;
        }

        if (label.equalsIgnoreCase("zed")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location pozice = player.getLocation().clone();
                pozice.add(0, 4, 0);
                pozice.getBlock().setType(Material.STONE);
            }
            return true;
        }

        if (label.equalsIgnoreCase("strecha")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location pozice = player.getLocation().clone();
                pozice.add(1, 2, 2);
                pozice.getBlock().setType(Material.STONE);
                pozice.add(1, 2, 2);
                pozice.getBlock().setType(Material.STONE);
                pozice.add(1, 2, 3);
                pozice.getBlock().setType(Material.STONE);
                pozice.add(1, 2, 2);
                pozice.getBlock().setType(Material.STONE);
                pozice.add(1, 2, 2);
                pozice.getBlock().setType(Material.STONE);
                pozice.add(1, 2, 2);
                pozice.getBlock().setType(Material.STONE);
                pozice.add(1, 2, 2);
                pozice.getBlock().setType(Material.STONE);
                pozice.add(1, 2, 2);
                pozice.getBlock().setType(Material.STONE);
            }
            return true;
        }

        return false;
    }}


















