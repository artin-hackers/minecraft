package cz.artin.hackers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import javax.swing.text.Position;

public class House {
    private Location playerLocation;

    public House(Location playerLocation) {
        this.playerLocation = playerLocation;
    }

    public void buildWallX(Location playerLocation) {
        playerLocation = playerLocation.clone();
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e < 5; e++) {
                playerLocation.add(e, i, 0);
                playerLocation.getBlock().setType(Material.OAK_PLANKS);
                playerLocation.add(-e, -i, -0);
            }
        }
    }
    public void buildWallZ(Location playerLocation) {
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e < 5; e++) {
                playerLocation.add(0, i, e);
                playerLocation.getBlock().setType(Material.OAK_PLANKS);
                playerLocation.add(-0, -i, -e);
            }
        }
    }
    public void buildRoof(Location playerLocation) {
        playerLocation = playerLocation.clone();

        playerLocation.add(-1, 4, -1);
        for (int i = 0; i < 5; i++) {
            for (int e = 0; e < 5; e++) {
                playerLocation.add(i, 0, e);
                playerLocation.getBlock().setType(Material.OAK_PLANKS);
                playerLocation.add(-i, 0, -e);
            }
        }

    }
    public void buildFloor(Location playerLocation) {
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

    public void buildDecorations (Location playerLocation) {
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
    public void buildRoad (Location playerLocation) {
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
    public void buildDoor (Location playerLocation) {
        playerLocation = playerLocation.clone();

        playerLocation.add(2, 0, 0);
        playerLocation.getBlock().setType(Material.AIR);
        playerLocation.add(0, 1, 0);
        playerLocation.getBlock().setType(Material.DARK_OAK_TRAPDOOR);
    }

    public void buildHouse () {
        playerLocation = playerLocation.clone();

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
    }

}
