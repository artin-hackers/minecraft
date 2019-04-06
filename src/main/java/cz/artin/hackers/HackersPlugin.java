package cz.artin.hackers;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;


public class HackersPlugin extends JavaPlugin {

    private List<Object> pozice;
    private Location teleportertamkdezacinamnazacatku;

    @Override
    public void onEnable() {
        getLogger().info("Hackers plugin se nacita...");
        getServer().getPluginManager().registerEvents(new MagicListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("vlk")) {
            return spawnWolf(sender);
        } else if (label.equalsIgnoreCase("kure")) {
            return spawnChicken(sender);
        } else if (label.equalsIgnoreCase("portal")) {
            return createTownPortal(sender);
        } else if (label.equalsIgnoreCase("kralik")) {
            return spawnRabbit(sender);
        } else if (label.equalsIgnoreCase("zombie")) {
            return spawnZombie(sender);
        } else if (label.equalsIgnoreCase("spider")) {
            return spawnSpider(sender);
        } else if (label.equalsIgnoreCase("most")) {
            return createBridge(sender);
        } else if (label.equalsIgnoreCase("zed")) {
            return createWall(sender);
        } else if (label.equalsIgnoreCase("zed2")) {
            return createWall2(sender);
        } else if (label.equalsIgnoreCase("cistic")) {
            return createcleaner(sender);
        } else if (label.equalsIgnoreCase("strecha1")) {
            return createRoof1(sender);
        } else if (label.equalsIgnoreCase("dum")) {
            return createHouse(sender);
        } else if (label.equalsIgnoreCase("strecha")) {
            return createRoof(sender);
        } else if (label.equalsIgnoreCase("bazen")) {
            return createPool(sender);
        } else if (label.equalsIgnoreCase("supermec")) {
            return createSword(sender);
        } else if (label.equalsIgnoreCase("teleport")) {
            return createTeleport(sender);
        } else if (label.equalsIgnoreCase("teleportnazacatek")) {
            return createTeleport(sender);
        } else if (label.equalsIgnoreCase("teleport2")) {
            return createTeleport2(sender);
        } else if (label.equalsIgnoreCase("magickykrumpac")) {
            return createMagicpickaxe(sender);
        } else if (label.equalsIgnoreCase("magickymec")) {
            return createMagicsword(sender);
        } else if (label.equalsIgnoreCase("zlatykrumpac")) {
            return createGoldenpicxase(sender);
        } else if (label.equalsIgnoreCase("magickysip")) {
            return createMagicarrow(sender);
        } else if (label.equalsIgnoreCase("magickydiamantovymec")) {
            return createMagicdiamondsword(sender);
        } else if (label.equalsIgnoreCase("magickalopata")) {
            return createMagicshovel(sender);
        } else if (label.equalsIgnoreCase("nicicilopata")) {
            return createDestroyingshovel(sender);
        } else if (label.equalsIgnoreCase("teleportovatnazacatek")) {
            return createTeleporttostart(sender);


        } else {
            Player player = (Player) sender;
            player.sendMessage("Unknown command!");
        }

        /*

        if (label.equalsIgnoreCase("kure")) {

        if (label.equalsIgnoreCase("kralik")) {

        if (label.equalsIgnoreCase("zombie")) {

            return true;
        }
        if (label.equalsIgnoreCase("spider")) {


            if (label.equalsIgnoreCase("most")) {

        if (label.equalsIgnoreCase("zed")) {


        if (label.equalsIgnoreCase("zed2")) {

        if (label.equalsIgnoreCase("cistic")) {

        if (label.equalsIgnoreCase("strecha1")) { // kontroluje ze prikaz je strecha

        if (label.equalsIgnoreCase("dum")) {




        if (label.equalsIgnoreCase("strecha")) {

        if (label.equalsIgnoreCase("bazen")) {


        if (label.equalsIgnoreCase("rybnik")) {
            vytvorMirybnik(sender);
            return true;
        }
        if (label.equalsIgnoreCase("ohrada")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location pozice = player.getLocation().clone();
                vytvorMiOhradu(pozice);
                vytvorMiOhradu2(pozice);
                pozice.add(4, 0, 0);
                vytvorMiOhradu(pozice);
                pozice.add(-4,0,4);
                vytvorMiOhradu2(pozice);
            }
            return true;
        }
        if (label.equalsIgnoreCase("supermec")) {

        if (label.equalsIgnoreCase("teleport")) {

        if (label.equalsIgnoreCase("teleportovatnazacatek")) {
            if (sender instanceof Player) {
                Player hrac = (Player) sender;
                final Location zacatek = new Location(hrac.getWorld(),29,64,2);
                hrac.teleport(zacatek);
            }
        }
        if (label.equalsIgnoreCase("teleport2")) {


         if (label.equalsIgnoreCase("magickykrumpac")) {

        if (label.equalsIgnoreCase("magickymec")) {

        if (label.equalsIgnoreCase("zlatykrumpac")) {


        if (label.equalsIgnoreCase("magickysip")) {

        if (label.equalsIgnoreCase("magickydiamantovymec")) {

        if (label.equalsIgnoreCase("magickalopata")) {

        if (label.equalsIgnoreCase("nicicilopata")) {

     */
        return false;
    }

    private boolean spawnWolf(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location pozicevlka = player.getLocation().clone();
            pozicevlka.add(5, 0, 0);
            Wolf vlk = player.getWorld().spawn(pozicevlka, Wolf.class);
        }
        return true;
    }

    private boolean spawnChicken(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location kureLocation = player.getLocation().clone();
            kureLocation.add(5, 0, 0);
            Chicken kure = player.getWorld().spawn(kureLocation, Chicken.class);
        }
        return true;
    }

    private boolean spawnRabbit(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location kralikLocation = player.getLocation().clone();
            kralikLocation.add(5, 0, 0);
            Rabbit kralik = player.getWorld().spawn(kralikLocation, Rabbit.class);

        }
        return true;
    }

    private boolean spawnZombie(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location zombikLocation = player.getLocation().clone();
            zombikLocation.add(5, 0, 0);
            Zombie zombik = player.getWorld().spawn(zombikLocation, Zombie.class);

        }
        return true;
    }

    private boolean createSword(CommandSender sender) {
    if (sender instanceof Player) {
        Player me = (Player) sender;
        ItemStack sword = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = sword.getItemMeta();
        meta.setDisplayName("supermec");
        sword.setItemMeta(meta);
        me.getInventory().addItem(sword);

        }
        return true;
    }


    private boolean createMagicarrow(CommandSender sender) {
    if (sender instanceof Player) {
        Player me = (Player) sender;
        ItemStack axe = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = axe.getItemMeta();
        meta.setDisplayName("magickysip");
        axe.setItemMeta(meta);
        me.getInventory().addItem(axe);

        }
        return true;
    }

    private boolean createMagicshovel (CommandSender sender) {
        if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.DIAMOND_SHOVEL, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("magickalopata");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);

            }
            return true;
        }









    private boolean spawnSpider(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location pavoukLocation = player.getLocation().clone();
            pavoukLocation.add(5, 0, 0);
            Spider pavouk = player.getWorld().spawn(pavoukLocation, Spider.class);

        }
        return true;
    }

    private boolean createBridge(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location pozice = player.getLocation().clone();
            pozice.add(0, 0, 5);
            pozice.getBlock().setType(Material.STONE);
            for (int i = 0; i < 10; i++) {
                pozice.add(1, 0, 0);
                pozice.getBlock().setType(Material.STONE);
            }
        }
        return true;
    }

    private boolean createWall(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location pozice = player.getLocation().clone();
            pozice.add(0, 0, 5);
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 10; i++) {
                    pozice.add(1, 0, 0);
                    pozice.getBlock().setType(Material.STONE);
                }
                pozice.add(-10, 1, 0);
            }
        }
        return true;
    }

    private boolean createWall2(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location pozice = player.getLocation().clone();
            pozice.add(0, 0, 5);
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 10; i++) {
                    pozice.add(0, 0, 1);
                    pozice.getBlock().setType(Material.STONE);

                }
                pozice.add(0, 1, -10);
            }
        }
        return true;
    }

    private boolean createcleaner(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            final Location playerLocation = player.getLocation();
            for (int x = -10; x <= 10; x++) {
                for (int y = 0; y <= 10; y++) {
                    for (int z = -10; z <= 10; z++) {
                        final Location blockLocation = new Location(player.getWorld(),
                                playerLocation.getX() + x,
                                playerLocation.getY() + y,
                                playerLocation.getZ() + z);
                        blockLocation.getBlock().setType(Material.AIR);
                    }
                }
            }
        }
        return true;
    }

    private boolean createRoof1(CommandSender sender) {
        if (sender instanceof Player) {                  // kontroluje jestli to poslal hrac
            Player player = (Player) sender;             // vytvor promenu player a dej si do ni odesilatele sender
            Location pozice = player.getLocation().clone(); //urcuje pozici hrace(promena)
            pozice.add(0, 5, 0);                  //pricte 0 5 0
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 10; i++) {
                    pozice.add(1, 0, 0);         //pricte 1 0 0
                    pozice.getBlock().setType(Material.STONE); //na tu pozici polozi kamen
                }
                pozice.add(-10, 0, 1);
            }
        }
        return true;
    }

    private boolean createTeleport(CommandSender sender) {
     if (sender instanceof Player) {
        Player hrac = (Player) sender;
        final Location mesto = new Location(hrac.getWorld(), 374, 78, -108);
        hrac.getLocation();
        hrac.teleport(mesto);
        }

        return true;
    }

    private boolean createTeleport2(CommandSender sender) {
        if (sender instanceof Player) {
            Player hrac = (Player) sender;
            final Location mesto = new Location(hrac.getWorld(), 176, 70, -245);
            hrac.teleport(mesto);
        }
        return true;
    }


    private boolean createMagicpickaxe (CommandSender sender) {
        if (sender instanceof Player) {
            Player me = (Player) sender;
            ItemStack axe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
            ItemMeta meta = axe.getItemMeta();
            meta.setDisplayName("magickykrumpac");
            axe.setItemMeta(meta);
            me.getInventory().addItem(axe);
        }

        return true;

    }

    private boolean createMagicsword (CommandSender sender) {
    if (sender instanceof Player) {
        Player me = (Player) sender;
        ItemStack axe = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = axe.getItemMeta();
        meta.setDisplayName("magickymec");
        axe.setItemMeta(meta);
        me.getInventory().addItem(axe);

         }

      return true;

    }

    private boolean createGoldenpicxase  (CommandSender sender) {
    if (sender instanceof Player) {
        Player me = (Player) sender;
        ItemStack axe = new ItemStack(Material.GOLDEN_PICKAXE, 1);
        ItemMeta meta = axe.getItemMeta();
        meta.setDisplayName("zlatykrumpac");
        axe.setItemMeta(meta);
        me.getInventory().addItem(axe);

        }
        return true;

    }


    private boolean createMagicdiamondsword   (CommandSender sender) {
        if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.DIAMOND_SWORD, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("magickydiamantovymec");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);

            }
            return true;
        }


    private boolean createDestroyingshovel   (CommandSender sender) {
        if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.GOLDEN_SHOVEL, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("nicicilopata");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);

            }
             return true;
        }


    private boolean createTeleporttostart   (CommandSender sender) {
         if (sender instanceof Player) {
                Player hrac = (Player) sender;
                final Location zacatek = new Location(hrac.getWorld(),29,64,2);
                hrac.teleport(zacatek);
            }
         return true;
        }







    private boolean createHouse(CommandSender sender) {
        if (sender instanceof Player) {                  // kontroluje jestli to poslal hrac
            Player player = (Player) sender;             // vytvor promenu player a dej si do ni odesilatele sender
            Location pozice = player.getLocation().clone(); //urcuje pozici hrace(promena)
            pozice.add(0, 5, 0);                  //pricte 0 5 0
            for (int j = 0; j < 6; j++) {
                for (int i = 0; i < 10; i++) {
                    pozice.add(1, 0, 0);         //pricte 1 0 0
                    pozice.getBlock().setType(Material.BLACK_CONCRETE); //na tu pozici polozi kamen
                }
                pozice.add(-10, 0, 1);
            }
        }
        return true;
    }

    private boolean createRoof(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location pozice = player.getLocation().clone();
            pozice.add(0, 0, 5);
            pozice.getBlock().setType(Material.STONE);
            pozice.add(1, 0, 0);
            pozice.getBlock().setType(Material.STONE);
            pozice.add(1, 0, 0);
            pozice.getBlock().setType(Material.STONE);
            pozice.add(1, 0, 0);
            pozice.getBlock().setType(Material.STONE);
            pozice.add(1, 0, 0);
            pozice.getBlock().setType(Material.STONE);
            pozice.add(1, 0, 0);
            pozice.getBlock().setType(Material.STONE);
            pozice.add(1, 0, 0);
            pozice.getBlock().setType(Material.STONE);
            pozice.add(1, 0, 0);
            pozice.getBlock().setType(Material.STONE);
        }
        return true;
    }

    private boolean createPool(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location pozice = player.getLocation().clone();
            vytvorMiBazen(pozice);
        }
        return true;
    }






    private boolean createTownPortal(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location portalLocation = player.getLocation().clone();
            portalLocation.add(5, 0, 0);
            portalLocation.getBlock().setType(Material.EMERALD_BLOCK);
        }
        return true;
    }


    //PROMENY:

    private boolean vytvorMiBazen(Location pozice) {
        Location pozicebazenu = pozice;
        pozice.add(0, -1, 0);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                pozice.add(1, 0, 0);
                pozicebazenu.getBlock().setType(Material.BRICKS);
            }
        }
        return true;
    }
}


    /*
    private boolean vytvorMirybnik(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location playerLocation = player.getLocation();
            for (int x = 0; x <= 3; x++) {
                for (int z = 0; z <= 3; z++) {
                    final Location blockLocation = new Location(player.getWorld(),
                            playerLocation.getX() + x,
                            playerLocation.getY() - 1,
                            playerLocation.getZ() + z);
                    blockLocation.getBlock().setType(Material.WATER);
                }
            }
        }
        return true;
    }

    private boolean vytvorMiMost(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location playerLocation = player.getLocation();
            for (int z = 0; z < 6; z++) {
                final Location blockLocation = new Location(player.getWorld(),
                        playerLocation.getX() + 1,
                        playerLocation.getY() + 1,
                        playerLocation.getZ() + z - 1);
                blockLocation.getBlock().setType(Material.GOLD_BLOCK);
            }
            return true;
        }
        return false;
    }

    private boolean vytvorMiOhradu(Location pozice) {
        for (int z = 0; z < 4; z++) {
            final Location blockLocation = new Location(pozice.getWorld(),
                    pozice.getX() + 0,
                    pozice.getY() + 0,
                    pozice.getZ() + z);
            blockLocation.getBlock().setType(Material.STONE);
        }
        return true;
    }

    private boolean vytvorMiOhradu2(Location pozice) {
        for (int x = 0; x < 4; x++) {
            final Location blockLocation = new Location(pozice.getWorld(),
                    pozice.getX() + x,
                    pozice.getY() + 0,
                    pozice.getZ() + 0);
            blockLocation.getBlock().setType(Material.STONE);
        }
        return true;
    }
 }
*/
