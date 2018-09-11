package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HackersPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hackers plugin se nacita...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("kure")){
            if(sender instanceof Player){
                Player player= (Player)sender;
                Location kureLocation=player.getLocation().clone();
                kureLocation.add(5,0,0);
                Chicken kure=player.getWorld().spawn(kureLocation,Chicken.class);

            }

            return true;
        }
        return false;
    }
}
