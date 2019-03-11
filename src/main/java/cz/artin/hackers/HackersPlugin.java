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
        if (label.equalsIgnoreCase("kralik")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location kralikLocation = player.getLocation().clone();
                kralikLocation.add(5, 0, 0);
                Rabbit kralik = player.getWorld().spawn(kralikLocation, Rabbit.class);

            }
            return true;
        }
        if (label.equalsIgnoreCase("zombie")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location zombikLocation = player.getLocation().clone();
                zombikLocation.add(5, 0, 0);
                Zombie zombik = player.getWorld().spawn(zombikLocation, Zombie.class);

            }
            return true;
        }
        if (label.equalsIgnoreCase("spider")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location pavoukLocation = player.getLocation().clone();
                pavoukLocation.add(5, 0, 0);
                Spider pavouk = player.getWorld().spawn(pavoukLocation, Spider.class);

            }
            return true;
        }

            if (label.equalsIgnoreCase("most")) {
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

        if (label.equalsIgnoreCase("zed")) { //kontroluje ze prikaz je zed
            if (sender instanceof Player) {               //kontroluje jestli to poslal hrac
                Player player = (Player) sender;          //vytvor promenu player a dej si do ni odesilatele sender
                Location pozice = player.getLocation().clone(); //urcuje pozici hrace (promena)
                pozice.add(0, 0, 5);                  //pricte 0 0 5
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < 10; i++) {
                        pozice.add(1, 0, 0);         //pricte 0 0 1
                        pozice.getBlock().setType(Material.STONE); //na tu pozici polozi diamand
                    }
                    pozice.add(-10, 1, 0);
                }
            }
            return true;
        }

        if (label.equalsIgnoreCase("zed2")) { //kontroluje ze prikaz je zed2
            if (sender instanceof Player) {                //kontroluje jestli to poslal hrac
                Player player = (Player) sender;           //vytvor promenu player a dej si do ni odesilatele sender
                Location pozice = player.getLocation().clone(); //určuje pozici hrace (promena)
                pozice.add(0, 0, 5);                  //pricte 0 0 5
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < 10; i++) {
                        pozice.add(0, 0, 1);         //pricte 0 0 1
                        pozice.getBlock().setType(Material.STONE); //na tu pozici polozi kamen

                    }
                    pozice.add(0, 1, -10);
                }
            }
            return true;
        }
        if (label.equalsIgnoreCase("cistic")) {
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
        if (label.equalsIgnoreCase("strecha1")) { // kontroluje ze prikaz je strecha
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
        }
        if (label.equalsIgnoreCase("dum")) { // kontroluje ze prikaz je strecha
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
        }
        if (label.equalsIgnoreCase("dum")) { //kontroluje ze prikaz je zed
            if (sender instanceof Player) {               //kontroluje jestli to poslal hrac
                Player player = (Player) sender;          //vytvor promenu player a dej si do ni odesilatele sender
                Location pozice = player.getLocation().clone(); //urcuje pozici hrace (promena)
                pozice.add(0, 0, 5);                  //pricte 0 0 5
                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < 10; i++) {
                        pozice.add(1, 0, 0);         //pricte 0 0 1
                        pozice.getBlock().setType(Material.BRICKS); //na tu pozici polozi diamand
                    }
                    pozice.add(-10, 1, 0);
                }
                Location poziceProBazen = pozice.clone();
                poziceProBazen.add(0, -5, -1);
                vytvorMiBazen(poziceProBazen.clone());
                vytvorMiBazen(poziceProBazen.clone().add(0, 0, -1));
                vytvorMiBazen(poziceProBazen.clone().add(0, 0, -1));
                vytvorMiBazen(poziceProBazen.clone().add(0, 0, -1));

            }

        }


        if (label.equalsIgnoreCase("strecha")) {
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
        if (label.equalsIgnoreCase("bazen")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location pozice = player.getLocation().clone();
                vytvorMiBazen(pozice);
            }
        }

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
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack sword = new ItemStack(Material.GOLDEN_SWORD, 1);
                ItemMeta meta = sword.getItemMeta();
                meta.setDisplayName("supermec");
                sword.setItemMeta(meta);
                me.getInventory().addItem(sword);
                return true;
            }
        }
        if (label.equalsIgnoreCase("teleport")) {
            if (sender instanceof Player) {
                Player hrac = (Player) sender;
                final Location mesto = new Location(hrac.getWorld(), 374, 78, -108);
                teleportertamkdezacinamnazacatku=hrac.getLocation();
                hrac.teleport(mesto);
            }
        }
        if (label.equalsIgnoreCase("tleportovatnazacatek")) {
            if (sender instanceof Player) {
                Player hrac = (Player) sender;
                hrac.teleport(teleportertamkdezacinamnazacatku);
            }
        }
        if (label.equalsIgnoreCase("teleport2")) {
            if (sender instanceof Player) {
                Player hrac = (Player) sender;
                final Location mesto = new Location(hrac.getWorld(),176,70, -245);
                hrac.teleport(mesto);
            }
        }

         if (label.equalsIgnoreCase("magickykrumpac")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("magickykrumpac");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }
        if (label.equalsIgnoreCase("magickymec")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.GOLDEN_SWORD, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("magickymec");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }

        if (label.equalsIgnoreCase("zlatykrumpac")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.GOLDEN_PICKAXE, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("zlatykrumpac");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }

        if (label.equalsIgnoreCase("magickysip")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.ARROW, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("magickysip");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }
        if (label.equalsIgnoreCase("magickydiamantovymec")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.DIAMOND_SWORD, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("magickydiamantovymec");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }
        if (label.equalsIgnoreCase("magickalopata")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.DIAMOND_SHOVEL, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("magickalopata");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }
        if (label.equalsIgnoreCase("nicicilopata")) {
            if (sender instanceof Player) {
                Player me = (Player) sender;
                ItemStack axe = new ItemStack(Material.GOLDEN_SHOVEL, 1);
                ItemMeta meta = axe.getItemMeta();
                meta.setDisplayName("nicicilopata");
                axe.setItemMeta(meta);
                me.getInventory().addItem(axe);
                return true;
            }
        }

        return false;
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



