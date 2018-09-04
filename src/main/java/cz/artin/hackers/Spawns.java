package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import static org.bukkit.Bukkit.getLogger;

public class Spawns {
    private enum directions {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public boolean spawnChickens(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (int i = 0; i < 5; i++) {
                Location chickenLocation = putInView(sender, 4);
                chickenLocation.add(0, i, 0);
                Chicken chicken = player.getWorld().spawn(chickenLocation, Chicken.class);
            }
            return true;
        }
        return false;
    }

    public boolean spawnZombie(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location zombieLocation = putInView(sender, 5);
            Zombie zombie = player.getWorld().spawn(zombieLocation, Zombie.class);
            return true;
        }
        return false;
    }

    public Spawns.directions getDirection(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int rotation = Math.round(player.getLocation().getYaw() + 270) % 360;
            if (rotation >= 45 && rotation < 135) {
                return Spawns.directions.NORTH;
            } else if (rotation >= 135 && rotation < 225) {
                return Spawns.directions.EAST;
            } else if (rotation >= 225 && rotation < 315) {
                return Spawns.directions.SOUTH;
            } else {
                return Spawns.directions.WEST;
            }
        }
        return null;
    }

    public Location putInView(CommandSender sender, int distance) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation().clone();
            Spawns.directions direction = getDirection(sender);
            if (direction == Spawns.directions.NORTH) {
                location.add(0, 0, -distance);
            } else if (direction == Spawns.directions.EAST) {
                location.add(distance, 0, 0);
            } else if (direction == Spawns.directions.SOUTH) {
                location.add(0, 0, distance);
            } else if (direction == Spawns.directions.WEST) {
                location.add(-distance, 0, 0);
            } else {
                getLogger().info("Error: putInView()");
                return null;
            }
            return location;
        }
        return null;
    }
}
