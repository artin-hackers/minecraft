package cz.artin.hackers;

import org.bukkit.Location;
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
        if(label.equalsIgnoreCase("vlk")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location pozicevlka = player.getLocation().clone();
                pozicevlka.add(5, 0, 0);
                Wolf vlk = player.getWorld().spawn(pozicevlka, Wolf.class);

            }
        }
        if (label.equalsIgnoreCase("kure")){
            if(sender instanceof Player){
                Player player= (Player)sender;
                Location kureLocation=player.getLocation().clone();
                kureLocation.add(5,0,0);
                Chicken kure=player.getWorld().spawn(kureLocation,Chicken.class);

            }

            return true;
        }
        if(label.equalsIgnoreCase("zed")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                final Location pozice= player.getLocation();
                final Location pozicezdi= new Location(player.getWorld(), pozice.getX(),pozice. getY(), pozice.getZ());


            }
        }

        return false;
    }
}
