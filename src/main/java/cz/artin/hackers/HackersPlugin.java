package cz.artin.hackers;


import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.bukkit.Material.*;


public class HackersPlugin extends JavaPlugin implements org.bukkit.event.Listener {

    public Location loc_st;
    private Location LAST_LOCATION;
    public boolean jeKoleckoNaTahu = false;
    public boolean jeKrizekNaTahu = false;
    private BossBar bb = getServer().createBossBar(ChatColor.LIGHT_PURPLE + "BOSSBAR " + ChatColor.WHITE + "► " + ChatColor.AQUA + "EZZZ", BarColor.PINK, BarStyle.SOLID);

    ArrayList<String> bannedPlayers = new ArrayList<>();
    HashMap<Player, Integer> perms = new HashMap<>();
    public ItemStack zpet;
    public static Inventory myInv = Bukkit.createInventory(null, 9, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "SELECT GAMEMODE B-)");
    public static Inventory kitInv = Bukkit.createInventory(null, 9, ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "SELECT KIT: ");
    public static Inventory ttt = Bukkit.createInventory(null, 54, ChatColor.RED + "" + ChatColor.BOLD + "TIC-TAC TOE");
    public static Inventory adminInv = Bukkit.createInventory(null, 9, ChatColor.GREEN + "ADMIN MENU");
    public static Inventory kickInv = Bukkit.createInventory(null, 54, ChatColor.RED + "KICK PLAYER");
    public static Inventory banInv = Bukkit.createInventory(null, 54, ChatColor.RED + "BAN PLAYER");
    public static Inventory unbanInv = Bukkit.createInventory(null, 54, ChatColor.RED + "UNBAN PLAYER");


    static {
        {
            ///////////////////////////////////////////adminInv
            ItemStack kick = new ItemStack(Material.RED_WOOL);
            ItemMeta kickMeta = kick.getItemMeta();
            kickMeta.setDisplayName(ChatColor.RED + "KICK PLAYER");
            kickMeta.setLore(Arrays.asList(ChatColor.GOLD + "Kick any player on this server " + ChatColor.GREEN + "<right click>"));
            kick.setItemMeta(kickMeta);
            ItemStack ban = new ItemStack(Material.BARRIER);
            ItemMeta banMeta = ban.getItemMeta();
            banMeta.setDisplayName(ChatColor.RED + "BAN PLAYER");
            banMeta.setLore(Arrays.asList(ChatColor.GOLD + "Ban any player on this server " + ChatColor.GREEN + "<right click>"));
            ban.setItemMeta(banMeta);
            ItemStack pardon = new ItemStack(Material.GREEN_WOOL);
            ItemMeta pardonMeta = pardon.getItemMeta();
            pardonMeta.setDisplayName(ChatColor.RED + "UNBAN PLAYER");
            pardonMeta.setLore(Arrays.asList(ChatColor.GOLD + "Unban any banned player " + ChatColor.GREEN + "<right click>"));
            pardon.setItemMeta(pardonMeta);
            adminInv.setItem(1, kick);
            adminInv.setItem(4, ban);
            adminInv.setItem(7, pardon);

        }
        {
            ////////////////////////////////////////////kickInv
            int index = 0;
            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                String owner = p.getName();
                headMeta.setOwner(owner);
                headMeta.setDisplayName(ChatColor.YELLOW + owner);
                head.setItemMeta(headMeta);
                kickInv.setItem(index, head);
                index++;
            }
        }
        {
            ///////////////////////////////////////////////banInv
            int index = 0;
            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                String owner = p.getName();
                headMeta.setOwner(owner);
                headMeta.setDisplayName(ChatColor.YELLOW + owner);
                head.setItemMeta(headMeta);
                banInv.setItem(index, head);
                index++;
            }
        }
        {
            ////////////////////////////////////////////myInv
            ItemStack bw = new ItemStack(Material.BLUE_WOOL);
            ItemMeta bwmeta = bw.getItemMeta();
            bwmeta.setDisplayName(ChatColor.AQUA + "CREATIVE");
            bwmeta.setLore(Arrays.asList("ZMENI TI GAMEMODE", "NA CREATIVE!!"));
            bw.setItemMeta(bwmeta);
            ItemStack rw = new ItemStack(Material.RED_WOOL);
            ItemMeta rwmeta = rw.getItemMeta();
            rwmeta.setDisplayName(ChatColor.RED + "SURVIVAL");
            rwmeta.setLore(Arrays.asList("ZMENI TI GAMEMODE", "NA SURVIVAL!!"));
            rw.setItemMeta(rwmeta);
            ItemStack lw = new ItemStack(Material.LIME_WOOL);
            ItemMeta lwmeta = lw.getItemMeta();
            lwmeta.setDisplayName(ChatColor.GREEN + "ADVENTURE");
            lwmeta.setLore(Arrays.asList("ZMENI TI GAMEMODE", "ADVENTURE!!"));
            lw.setItemMeta(lwmeta);
            myInv.setItem(1, bw);
            myInv.setItem(4, rw);
            myInv.setItem(7, lw);
        }
        {
            /////////////////////////////////////////unbanInv
            for (int i = 0; i < 54; i++) {
                unbanInv.setItem(i, new ItemStack(Material.AIR));
            }
        }
        {
            //////////////////////////////////////////////kitInv
            ItemStack archer = new ItemStack(Material.BOW);
            ItemMeta archerMeta = archer.getItemMeta();
            archerMeta.setDisplayName(ChatColor.GOLD + "ARCHER");
            archerMeta.setLore(Arrays.asList(ChatColor.GREEN + "1x luk", ChatColor.GREEN + "16x sip", ChatColor.GREEN + "32x blok"));
            archer.setItemMeta(archerMeta);
            ItemStack bomber = new ItemStack(Material.TNT);
            ItemMeta bomberMeta = bomber.getItemMeta();
            bomberMeta.setDisplayName(ChatColor.GOLD + "BOMBER");
            bomberMeta.setLore(Arrays.asList(ChatColor.GREEN + "5x bomba", ChatColor.GREEN + "1x throwing speed potion", ChatColor.GREEN + "1x kamenny mec"));
            bomber.setItemMeta(bomberMeta);
            ItemStack spy = new ItemStack(Material.RABBIT_HIDE);
            ItemMeta spyMeta = spy.getItemMeta();
            spyMeta.setDisplayName(ChatColor.GOLD + "SPY");
            spyMeta.setLore(Arrays.asList(ChatColor.GREEN + "1x menic armoru", ChatColor.GREEN + "1x kamenny mec", ChatColor.GREEN + "5x jablko"));
            spy.setItemMeta(spyMeta);
            kitInv.setItem(0, archer);
            kitInv.setItem(1, bomber);
            kitInv.setItem(2, spy);
        }
        {
            /////////////////////////////////Tic-Tac-Toe
            for (int i = 0; i < 53; i++) {
                ttt.setItem(i, new ItemStack(Material.OAK_BOAT));
            }
            ItemStack reset = new ItemStack(Material.BARRIER);
            ItemMeta meta = reset.getItemMeta();
            meta.setDisplayName(ChatColor.RED + "RESET");
            reset.setItemMeta(meta);
            ttt.setItem(53, reset);
        }

    }


    @Override
    public void onEnable() {
        getLogger().info("Michal Himer");
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this, this);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
            }
        }, 0, 20);


        {
            ItemStack item = new ItemStack(EXPERIENCE_BOTTLE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.LIGHT_PURPLE + "EXP LAHVICKA");
            meta.setLore(Arrays.asList("OPATRNE!!", "Tato tycka muze", "napachat skody!!"));
            item.setItemMeta(meta);
            NamespacedKey key = new NamespacedKey(this, "experience_bottle");
            ShapedRecipe recipe = new ShapedRecipe(key, item);
            recipe.shape("%B%", "B/B", "%B%");
            recipe.setIngredient('%', INK_SAC);
            recipe.setIngredient('B', SUGAR);
            recipe.setIngredient('/', GLASS_BOTTLE);
            Bukkit.addRecipe(recipe);
        }
        {
            ItemStack item = new ItemStack(BARRIER, 10);
            ItemMeta meta = item.getItemMeta();
            NamespacedKey key = new NamespacedKey(this, "barrier");
            ShapedRecipe recipe = new ShapedRecipe(key, item);
            recipe.shape(" AA",
                    " BB",
                    "   ");
            recipe.setIngredient('A', STONE);
            recipe.setIngredient('B', GLASS);
            Bukkit.addRecipe(recipe);
        }
        {
            ItemStack item = new ItemStack(BLAZE_ROD);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.LIGHT_PURPLE + "POWERTYCKA");
            meta.setLore(Arrays.asList("Toto je powertycka.", "Ale opatrne!!", "Daji se s ni", "napachat velike skody!"));
            item.setItemMeta(meta);
            NamespacedKey key = new NamespacedKey(this, "blaze_rod");
            ShapedRecipe recipe = new ShapedRecipe(key, item);
            recipe.shape("%%%", "%D%", "%%%");
            recipe.setIngredient('%', BLAZE_ROD);
            recipe.setIngredient('D', DIAMOND);
            Bukkit.addRecipe(recipe);
        }

        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            if (p.getName().equals("4everM3loun") && !(perms.containsKey(p))) {
                perms.put(p, 5);
            } else if (!(perms.containsKey(p))) {
                perms.put(p, 1);
            }
        }
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            String name = p.getName();
            if (perms.get(p) == 5) {
                p.setCustomName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
                p.setCustomNameVisible(true);
                p.setPlayerListName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
                p.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
            }
            else if (perms.get(p) == 4) {
                p.setCustomName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
                p.setCustomNameVisible(true);
                p.setPlayerListName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
                p.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
            }
        }

        getLogger().info("perms size:" + perms.size());

        zpet = new ItemStack(Material.SLIME_BALL);
        ItemMeta zpetMeta = zpet.getItemMeta();
        zpetMeta.setDisplayName(ChatColor.BLUE + "BACK");
        zpetMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Back to admin menu."));
        zpet.setItemMeta(zpetMeta);
        getLogger().info("On enable was succesful :)");
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player me = (Player) sender;
        World svet = me.getWorld();
        Location lokace = me.getLocation();


        Player p = (Player) sender;
        if (label.equalsIgnoreCase("adminmenu")) {
            Integer perm = perms.get(me);
            if (perm >= 5) {
                p.openInventory(adminInv);
            } else {
                me.sendMessage(ChatColor.RED + "You havent got sufficient permits to do that! Sorry. Ask admin if you can get higher permits...");
            }
        }
        if  (label.equalsIgnoreCase("perms")) {
            Integer level = perms.get(me);
            p.sendMessage(""+level);
        }
        if (label.equalsIgnoreCase("promote")) {
            if (perms.get(me) >= 5) {
                if (args.length > 0) {
                    String target = args[0];
                    for (Player pl: Bukkit.getServer().getOnlinePlayers()) {
                        if (pl.getName().equals(target) && perms.containsKey(pl)) {
                            Integer level = perms.get(pl);
                            if (!(level >= 5)) {
                                level++;
                                perms.replace(pl, level);
                                p.sendMessage(ChatColor.GREEN + "Player " + ChatColor.YELLOW + target + ChatColor.GREEN + " was succesfuly promoted. His permits level is now: " + ChatColor.AQUA + level);
                                pl.sendMessage(ChatColor.GREEN+"You have been promoted by " + ChatColor.YELLOW+p.getName()+ChatColor.GREEN+". Your permits level is now: " + ChatColor.AQUA+level);
                                for (Player pla : Bukkit.getServer().getOnlinePlayers()) {
                                    String name = pla.getName();
                                    if (perms.get(pla) == 5) {
                                        pla.setCustomName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
                                        pla.setCustomNameVisible(true);
                                        pla.setPlayerListName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
                                        pla.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
                                    }
                                    else if (perms.get(p) == 4) {
                                        pla.setCustomName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
                                        pla.setCustomNameVisible(true);
                                        pla.setPlayerListName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
                                        pla.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
                                    }
                                }
                            }
                            else {
                                p.sendMessage(ChatColor.RED+"The player you have specified has already highest possible perms!");
                            }
                        }
                    }

                } else {
                    p.sendMessage(ChatColor.RED + "You forgot to define a player!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "You havent got sufficient permits to do that! Sorry. Ask admin if you can get higher permits...");
            }

        }
        if (label.equalsIgnoreCase("demote")) {
            if (perms.get(me) >= 5) {
                if (args.length > 0) {
                    String target = args[0];
                    for (Player pl: Bukkit.getServer().getOnlinePlayers()) {
                        if (pl.getName().equals(target) && perms.containsKey(pl)) {
                            Integer level = perms.get(pl);
                            if (!(level <= 0)) {
                                level--;
                                perms.replace(pl, level);
                                p.sendMessage(ChatColor.GREEN + "Player " + ChatColor.YELLOW + target + ChatColor.GREEN + " was succesfuly demoted. His permits level is now: " + ChatColor.AQUA + level);
                                pl.sendMessage(ChatColor.RED+"You have been demoted by " + ChatColor.YELLOW+p.getName()+ChatColor.RED+". Your permits level is now: " + ChatColor.AQUA+level);
                                for (Player pla : Bukkit.getServer().getOnlinePlayers()) {
                                    String name = pla.getName();
                                    if (perms.get(pla) == 5) {
                                        pla.setCustomName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
                                        pla.setCustomNameVisible(true);
                                        pla.setPlayerListName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
                                        pla.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"[ADMIN] "+name);
                                    }
                                    else if (perms.get(p) == 4) {
                                        pla.setCustomName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
                                        pla.setCustomNameVisible(true);
                                        pla.setPlayerListName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
                                        pla.setDisplayName(ChatColor.RED+""+ChatColor.BOLD+"[YOUTUBER] "+name);
                                    }
                                }
                            }
                            else {
                                p.sendMessage(ChatColor.RED+"The player you have specified has already lowest possible perms!");
                            }
                        }

                    }

                } else {
                    p.sendMessage(ChatColor.RED + "You forgot to define a player!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "You havent got sufficient permits to do that! Sorry. Ask admin if you can get higher permits...");
            }

        }

        if (label.equalsIgnoreCase("nick")) {


            if (args.length == 0) {
                p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "MENIC JMENA" + ChatColor.BLUE + "] " + ChatColor.RED + "Nezminil jsi nick!");
                return true;
            }

            String nick = "";
            for (String arg : args) {
                nick += arg + " ";
            }

            nick = nick.substring(0, nick.length() - 1);

            nick = nick.replaceAll("&", "§");


            if (nick.equalsIgnoreCase("reset")) {
                nick = ((Player) sender).getName();
            }
            if (!(nick.equalsIgnoreCase("reset"))) {
                if (!(nick.equalsIgnoreCase("PrejetaKlobasa"))) {
                    if (!(nick.equalsIgnoreCase("CervenaBrambora"))) {
                        if (!(nick.equalsIgnoreCase("SmidlikaciJsouBest"))) {
                            if (!(nick.equalsIgnoreCase("rgrgsrg"))) {
                                for (PotionEffect effect : p.getActivePotionEffects())
                                    p.removePotionEffect(effect.getType());
                            }
                        }
                    }
                }
            }
            if (nick.equalsIgnoreCase("PrejetaKlobasa")) {
                PotionEffect ef1 = new PotionEffect(PotionEffectType.HARM, Integer.MAX_VALUE, 5);
                p.addPotionEffect(ef1);
                p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "MENIC JMENA" + ChatColor.BLUE + "] " + ChatColor.WHITE + "OOPS! Zda se ze te neco prejelo");
                nick = ((Player) sender).getName();
            }
            if (nick.equalsIgnoreCase("CervenaBrambora")) {
                PotionEffect ef2 = new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1);
                p.addPotionEffect(ef2);
                p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "MENIC JMENA" + ChatColor.BLUE + "] " + ChatColor.WHITE + "Cervena brambora je hodne dobra protoze se sama regeneruje! B)");

            }
            if (nick.equalsIgnoreCase("SmidlikaciJsouBest")) {

                for (int i = 1; i < 65; i++) {
                    ItemStack diamond = new ItemStack(DIAMOND);
                    ItemMeta diamondmeta = diamond.getItemMeta();
                    diamond.setItemMeta(diamondmeta);
                }

                p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "MENIC JMENA" + ChatColor.BLUE + "] " + ChatColor.WHITE + "To je spravne tvrzeni. Dostavas odmenu! :)");

            }
            if (nick.equalsIgnoreCase("rgrgsrg")) {
                p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "MENIC JMENA" + ChatColor.BLUE + "] " + ChatColor.WHITE + "Ziskal jste titul boha. Hodne nizko pod rgrgsrgem");
            }

            p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "MENIC JMENA" + ChatColor.BLUE + "] " + ChatColor.GREEN + "Tvuj nick byl zmenen na " + nick);

            this.getConfig().set(p.getName(), nick);
            this.saveConfig();
        }

        if (label.equalsIgnoreCase("Head")) {
            String target = args[0];
            ItemStack h = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta hmeta = (SkullMeta) h.getItemMeta();
            hmeta.setOwner(target);
            h.setItemMeta(hmeta);
            me.getInventory().addItem(h);

        }
        if (label.equalsIgnoreCase("build_c")) {
            if (sender instanceof Player) {
                lokace.add(0, -1, 0);
                for (int i = 1; i < 6; i++) {
                    lokace.add(0, 0, 1);
                    lokace.getBlock().setType(BRICKS);
                }
            }
        }
        if (label.equalsIgnoreCase("build_d")) {
            if (sender instanceof Player) {
                lokace.add(0, -1, 0);
                for (int i = 1; i < 6; i++) {
                    lokace.add(0, 0, -1);
                    lokace.getBlock().setType(BRICKS);
                }
            }
        }
        if (label.equalsIgnoreCase("zed")) {
            if (sender instanceof Player) {
                lokace.add(1, -1, 0);
                for (int i = 1; i < 5; i++) {
                    lokace.add(0, 1, 0);
                    lokace.getBlock().setType(BRICKS);
                }
                lokace.add(0, -4, 1);
                for (int i = 1; i < 5; i++) {
                    lokace.add(0, 1, 0);
                    lokace.getBlock().setType(BRICKS);
                }
                lokace.add(0, -4, 1);
                for (int i = 1; i < 5; i++) {
                    lokace.add(0, 1, 0);
                    lokace.getBlock().setType(BRICKS);
                }
                lokace.add(0, -4, -3);
                for (int i = 1; i < 5; i++) {
                    lokace.add(0, 1, 0);
                    lokace.getBlock().setType(BRICKS);
                }
                lokace.add(0, -4, -1);
                for (int i = 1; i < 5; i++) {
                    lokace.add(0, 1, 0);
                    lokace.getBlock().setType(BRICKS);
                }

            }
        }

        if (label.equalsIgnoreCase("chcibytartinhacker")) {
            if (sender instanceof Player) {
                Player misto = (Player) sender;
                ItemStack tycka = new ItemStack(STICK);
                ItemMeta stickmeta = tycka.getItemMeta();
                stickmeta.setDisplayName(ChatColor.AQUA + "Hackerska tycka");
                tycka.setItemMeta(stickmeta);
                misto.getInventory().addItem(tycka);
            }
        }


        if (label.equalsIgnoreCase("dum")) {
            if (sender instanceof Player) {
                dum.Dum(lokace);
            }
        }


        if (label.equalsIgnoreCase("powertycka")) {
            if (sender instanceof Player) {


                ItemStack tycka = new ItemStack(BLAZE_ROD);
                ItemMeta stickmeta = tycka.getItemMeta();
                stickmeta.setDisplayName(ChatColor.LIGHT_PURPLE + "POWERTYCKA");
                tycka.setItemMeta(stickmeta);
                me.getInventory().addItem(tycka);
                me.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "POWERTYCKA" + ChatColor.BLUE + "] " + ChatColor.GOLD + "Dostal jsi powertycku! Ale opatrne! Daji se s ni napachat velke skody!");
            }
        }
        if (label.equalsIgnoreCase("kit")) {
            p.openInventory(kitInv);

        }

        if (label.equalsIgnoreCase("kure")) {
            if (sender instanceof Player) {
                Location kureloc = me.getLocation();
                for (int i = 1; i < 21; i++) {
                    Chicken chicken = me.getWorld().spawn(kureloc, Chicken.class);
                }

            }
        }
        if (label.equalsIgnoreCase("vlcek")) {
            if (sender instanceof Player) {
                Location vlkloc = me.getLocation();
                Wolf wolf = me.getWorld().spawn(vlkloc, Wolf.class);

            }
        }
        if (label.equalsIgnoreCase("launchpad")) {
            if (sender instanceof Player) {
                lokace.add(0, 10, 0);
                me.teleport(lokace);
                me.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "LAUNCHPAD" + ChatColor.BLUE + "] " + ChatColor.WHITE + "Byl jsi uspesne launchnut");
            }
        }
        if (label.equalsIgnoreCase("bbcreate")) {

            bb.setColor(BarColor.GREEN);
            bb.setStyle(BarStyle.SOLID);
            bb.setProgress(0.666);
            bb.addPlayer(p);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                public void run() {
                    bb.removeAll();
                }
            }, 20 * 20);


        }
//        if (label.equalsIgnoreCase("bbtoggle")) {
//            if (args.length <= 0) {
//                p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "BOSSBAR" + ChatColor.BLUE + "] " + ChatColor.RED + "NEZMINIL JSI STAV!");
//            }
//            else {
//                Boolean toggleon = false;
//                if (args[0].equalsIgnoreCase("on")) {
//                    toggleon = true;
//                }
//                else if (args[0].equalsIgnoreCase("off")) {
//                    toggleon = false;
//                }
//                else {
//                    p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "BOSSBAR" + ChatColor.BLUE + "] " + ChatColor.RED + "TOGGLE BOSSBAR MUZE BYT JEN ZAPNUT NEBO VYPNUT!!!");
//                }
//                while (toggleon == true) {
//                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
//                        public void run() {
//                            bb.setTitle(ChatColor.LIGHT_PURPLE + "BOSSBAR" + ChatColor.WHITE + "► " + ChatColor.AQUA + "EAZY BOY!!");
//                        }
//                    }, 5 * 20);
//                }
//            }
//        }
        if (label.equalsIgnoreCase("warp")) {

            if (args.length == 0) {
                me.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "WARP" + ChatColor.BLUE + "] " + ChatColor.RED + "Nezadal jsi misto!");
                return true;
            }

            String misto = "";
            for (String arg : args) {
                misto += arg + " ";
            }


            misto = misto.substring(0, misto.length() - 1);
            getLogger().info(misto);
            if (misto.equalsIgnoreCase("HealShop")) {

                Location HealShop = new Location(me.getWorld(), 502, 240, 499);


                LAST_LOCATION = p.getLocation().clone();
                getLogger().info("warping...");
                getLogger().info("warping to: " + loc_st);
                me.teleport(HealShop);
            }
        }


        if (label.equalsIgnoreCase("w")) {
            World w = (World) p.getWorld();
            World templateworld = this.getServer().createWorld(new WorldCreator(this.getConfig().getString("templateworldname")));
        }
        if (label.equalsIgnoreCase("gm")) {
            me.openInventory(myInv);
        }
        if (label.equalsIgnoreCase("tictactoe")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "MUSIS SPECIFIKOVAT SPOLUHRACE!!");
            } else {
                final Player target = Bukkit.getServer().getPlayer(args[0]);
                p.openInventory(ttt);
                target.openInventory(ttt);
                jeKoleckoNaTahu = true;
            }
        }


        return true;


    }


    @EventHandler


    public void onSignChange(SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("[Uzdravit]")) {
            e.setLine(0, ChatColor.AQUA + "[Uzdravit]");
            e.setLine(1, ChatColor.AQUA + "Klikni zde");
            e.setLine(2, ChatColor.AQUA + "pro uzdraveni!");
        }
        if (e.getLine(0).equalsIgnoreCase("[Dojist]")) {
            e.setLine(0, ChatColor.AQUA + "[Dojist]");
            e.setLine(1, ChatColor.AQUA + "Klikni zde");
            e.setLine(2, ChatColor.AQUA + "pro dojezeni!");
        }
        if (e.getLine(0).equalsIgnoreCase("[Zpet]")) {
            e.setLine(0, ChatColor.AQUA + "[Zpet]");
            e.setLine(1, ChatColor.AQUA + "Klikni zde");
            e.setLine(2, ChatColor.AQUA + "pro warpnuti zpet!");
        }
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (e.getPlayer().getName().equals("4everM3loun") && !(perms.containsKey(e.getPlayer()))) {
            perms.put(e.getPlayer(), 5);
        } else if (!(perms.containsKey(e.getPlayer()))) {
            perms.put(e.getPlayer(), 1);
        }
        p.sendMessage(ChatColor.GREEN + "WELCOME ON SERVER " + ChatColor.YELLOW + p.getName());

    }

    public void onPlayerQuit(PlayerQuitEvent e) {

    }


    @EventHandler

    public void onPlazerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
            if (itemInMainHand != null && itemInMainHand.getItemMeta() != null) {
                if (itemInMainHand.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "POWERTYCKA")) {
                    event.getPlayer().launchProjectile(Fireball.class);
                    event.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "POWERTYCKA" + ChatColor.BLUE + "] " + ChatColor.GOLD + "Byla seslana fireball!");
                }
            }

        }
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
            if (itemInMainHand != null && itemInMainHand.getItemMeta() != null) {
                if (itemInMainHand.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "POWERTYCKA")) {


                    event.getPlayer().launchProjectile(Arrow.class);
                    event.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "POWERTYCKA" + ChatColor.BLUE + "] " + ChatColor.GOLD + "Byl seslan sip!");
                }
            }

        }
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
            if (itemInMainHand != null && itemInMainHand.getItemMeta() != null) {
                if (itemInMainHand.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Hackerska tycka")) {
                    boolean hackZapnut = true;
                    Player ja = event.getPlayer();
                    Location loc = ja.getLocation();
                    loc.add(0, -1, 0);
                    while (hackZapnut == true) {
                        Block blok = (Block) loc.getBlock();
                        loc.getBlock().setType(STONE);
                    }
                }
            }

        }
        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();
            if (itemInMainHand != null && itemInMainHand.getItemMeta() != null) {
                if (itemInMainHand.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Hackerska tycka")) {
                    boolean hackZapnut = false;
                    while (hackZapnut == false) {

                    }
                }
            }

        }
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
            if (hand != null && hand.getItemMeta() != null) {
                if (hand.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "MENIC ARMORU")) {
                    {
                        ItemStack helma = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta meta = (LeatherArmorMeta) helma.getItemMeta();
                        meta.setColor(Color.LIME);
                        helma.setItemMeta(meta);
                        event.getPlayer().getInventory().setHelmet(helma);
                    }
                    {
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chmeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chmeta.setColor(Color.LIME);
                        chestplate.setItemMeta(chmeta);
                        event.getPlayer().getInventory().setChestplate(chestplate);
                    }
                    {
                        ItemStack gate = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta meta = (LeatherArmorMeta) gate.getItemMeta();
                        meta.setColor(Color.LIME);
                        gate.setItemMeta(meta);
                        event.getPlayer().getInventory().setLeggings(gate);
                    }
                    {
                        ItemStack boty = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta meta = (LeatherArmorMeta) boty.getItemMeta();
                        meta.setColor(Color.LIME);
                        boty.setItemMeta(meta);
                        event.getPlayer().getInventory().setBoots(boty);
                    }
                    ItemStack ma = new ItemStack(Material.RABBIT_HIDE);
                    ItemMeta maMeta = ma.getItemMeta();
                    maMeta.setLore(Arrays.asList("Klikni na blok pro", "zmenu barvy armoru!"));
                    maMeta.setDisplayName(ChatColor.GREEN + "MENIC ARMORU");
                    ma.setItemMeta(maMeta);
                    event.getPlayer().getInventory().removeItem(ma);
                    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
                        public void run() {
                            event.getPlayer().getInventory().setHelmet(null);
                            event.getPlayer().getInventory().setChestplate(null);
                            event.getPlayer().getInventory().setLeggings(null);
                            event.getPlayer().getInventory().setBoots(null);
                        }
                    }, 60 * 20, 0);
                }
            }
        }


    }


    private boolean vytvorMiBazen(Location plloc) {
        Location poziceMehoBazenu = plloc;
        poziceMehoBazenu.add(0, -1, 0);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                poziceMehoBazenu.add(1, 0, 0);
                poziceMehoBazenu.getBlock().setType(WATER);
            }
        }
        return true;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (this.getConfig().getString(e.getPlayer().getName()) != null) {
            e.getPlayer().setDisplayName(this.getConfig().getString(e.getPlayer().getName()) + ChatColor.RESET);
        }
    }


    @EventHandler

    public void onPlaberInteract(PlayerInteractEvent e) {

        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign) e.getClickedBlock().getState();
            if (s.getLine(0).equalsIgnoreCase(ChatColor.AQUA + "[Uzdravit]")) {

                getLogger().info(s.getLine(0));
                e.getPlayer().setHealth(20);
                e.getPlayer().getInventory().addItem(new ItemStack(Material.RABBIT_HIDE));
                e.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "DOHEALOVANI" + ChatColor.BLUE + "] " + ChatColor.WHITE + "Dohealoval jsi se!");
            } else {
                e.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "DOHEALOVANI" + ChatColor.BLUE + "] " + ChatColor.RED + "Bohuzel nemate dostatecne permise aby jste mohli vyuzivat tuto OP vec...");
            }


        }
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign) e.getClickedBlock().getState();
            if (s.getLine(0).equalsIgnoreCase(ChatColor.AQUA + "[Dojist]")) {

                getLogger().info(s.getLine(0));
                e.getPlayer().setFoodLevel(20);
                e.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "DOJEZENI" + ChatColor.BLUE + "] " + ChatColor.WHITE + "Dojedl jsi se!");
            } else {
                e.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "DOJEZENI" + ChatColor.BLUE + "] " + ChatColor.RED + "Bohuzel nemate dostatecne permise aby jste mohli vyuzivat tuto OP vec...");
            }


        }

        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) ;

        if (e.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign) e.getClickedBlock().getState();
            if (s.getLine(0).equalsIgnoreCase(ChatColor.AQUA + "[Zpet]")) {

                getLogger().info(s.getLine(0));
                getLogger().info("Michal Himer:" + loc_st);
                if (!(LAST_LOCATION == null)) {
                    getLogger().info("FAKCI TO");
                    e.getPlayer().teleport(LAST_LOCATION);
                    e.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "WARP" + ChatColor.BLUE + "] " + ChatColor.WHITE + "Byl jsi uspense teleportovan zpet");
                } else {
                    e.getPlayer().teleport(e.getPlayer().getLocation());
                    getLogger().info("NEFAKCI TO");
                    e.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "WARP" + ChatColor.BLUE + "] " + ChatColor.RED + "ERROR 404 - Misto nebylo nalezeno");
                }

            } else {
                e.getPlayer().sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "WARP" + ChatColor.BLUE + "] " + ChatColor.RED + "Bohuzel nemate dostatecne permise aby jste mohli vyuzivat tuto OP vec...");
            }


        }
//        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK));
//        if (e.getClickedBlock().getState() instanceof Sign) {
//            Sign s = (Sign) e.getClickedBlock().getState();
//            if (s.getLine(0).equalsIgnoreCase("[Fly]")) {
//                e.getPlayer().sendTitle("Ahoj", "Jak se mas?", 2 * 20,5 * 20,2 * 20);
//                e.getPlayer().setAllowFlight(true);
//            }
//        }


    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        Projectile p = e.getEntity();
        if (!(p instanceof Snowball)) return;
        Snowball s = (Snowball) p;
        s.getWorld().createExplosion(s.getLocation(), 50.0F);
        for (Entity en : s.getNearbyEntities(10, 10, 10)) {
            if (en instanceof Player) {
                Player pl = (Player) en;
                if (pl == e.getEntity().getShooter()) {
                    pl.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, Integer.MAX_VALUE));
                }
                if (!(pl == e.getEntity().getShooter())) {
                    pl.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
                    pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
                }
            }
        }
    }

    @EventHandler
    public void onIventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inv = e.getInventory();
        Inventory pi = p.getInventory();
        if (inv.getName().equals(myInv.getName())) {
            if (clicked.getType() == Material.BLUE_WOOL) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "CREATIVE")) {
                    e.setCancelled(true);
                    getLogger().info("1k");
                    p.closeInventory();
                    p.setGameMode(GameMode.CREATIVE);

                }
            } else if (clicked.getType() == Material.RED_WOOL) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + "SURVIVAL")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.setGameMode(GameMode.SURVIVAL);
                }
            } else if (clicked.getType() == Material.LIME_WOOL) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "ADVENTURE")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.setGameMode(GameMode.ADVENTURE);
                }
            }
        } else if (inv.getName().equals(kitInv.getName())) {
            if (clicked.getType() == Material.BOW) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "ARCHER")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    ItemStack luk = new ItemStack(BOW);
                    luk.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
                    pi.addItem(luk);
                    pi.addItem(new ItemStack(ARROW, 16));
                    pi.addItem(new ItemStack(OAK_PLANKS, 32));
                    p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "KIT" + ChatColor.BLUE + "] " + ChatColor.WHITE + "Dostal jsi kit: " + ChatColor.GOLD + "ARCHER");
                }
            }
            if (clicked.getType() == Material.TNT) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "BOMBER")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    ItemStack grenade = new ItemStack(Material.SNOWBALL, 5);
                    ItemMeta grenadeMeta = grenade.getItemMeta();
                    grenadeMeta.setDisplayName(ChatColor.GREEN + "GRANAT");
                    grenadeMeta.setLore(Arrays.asList(ChatColor.AQUA + "Hod pro vybuch!", ChatColor.AQUA + "Zpusobi hraci poision", ChatColor.AQUA + "a zpomaleni na  sekund!"));
                    grenade.setItemMeta(grenadeMeta);
                    pi.addItem(grenade);
                    Potion splash = new Potion(PotionType.SPEED, 1);
                    splash.setSplash(true);
                    pi.addItem(splash.toItemStack(1));
                    pi.addItem(new ItemStack(Material.STONE_SWORD));
                    p.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "KIT" + ChatColor.BLUE + "] " + ChatColor.WHITE + "Dostal jsi kit: " + ChatColor.GOLD + "BOMBER");
                }
            }
            if (clicked.getType() == Material.RABBIT_HIDE) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "SPY")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    ItemStack ma = new ItemStack(Material.RABBIT_HIDE);
                    ItemMeta maMeta = ma.getItemMeta();
                    maMeta.setLore(Arrays.asList("Klikni na blok pro", "zmenu barvy armoru!"));
                    maMeta.setDisplayName(ChatColor.GREEN + "MENIC ARMORU");
                    ma.setItemMeta(maMeta);
                    ItemStack hlava = new ItemStack(Material.PLAYER_HEAD);

                    pi.addItem(ma);
                    pi.addItem(new ItemStack(Material.STONE_SWORD));
                    pi.addItem(new ItemStack(Material.APPLE));
                }
            }
        } else if (inv.getName().equals(ttt.getName())) {
            if (clicked.getType() == Material.OAK_BOAT && inv.getName().equals(ttt.getName())) {
                if (jeKoleckoNaTahu) {
                    e.setCancelled(true);
                    getLogger().info("1k");
                    clicked.setType(Material.DARK_OAK_PLANKS);
                    for (HumanEntity he : inv.getViewers()) {
                        Player player = (Player) he;
                        player.updateInventory();
                    }
                    getLogger().info("2k");
                    jeKoleckoNaTahu = false;
                    jeKrizekNaTahu = true;
                } else if (jeKrizekNaTahu) {
                    e.setCancelled(true);
                    getLogger().info("1a");
                    clicked.setType(Material.OAK_PLANKS);
                    for (HumanEntity he : inv.getViewers()) {
                        Player player = (Player) he;
                        player.updateInventory();
                    }
                    getLogger().info("2a");
                    jeKrizekNaTahu = false;
                    jeKoleckoNaTahu = true;
                } else {
                    getLogger().info("nefunguje to ");
                }
            } else if (clicked.getType() == Material.DARK_OAK_PLANKS) e.setCancelled(true);
            else if (clicked.getType() == Material.OAK_PLANKS) e.setCancelled(true);
            else if (clicked.getType() == Material.BARRIER) {
                e.setCancelled(true);
                ticTacReset();
            }

        } else if (inv.getName().equals(adminInv.getName())) {
            if (clicked.getType() == Material.RED_WOOL) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + "KICK PLAYER")) {
                    getLogger().info("Someone decided to kick a player");
                    e.setCancelled(true);
                    p.closeInventory();
                    for (int i = 0; i < 54; i++) {
                        kickInv.setItem(i, new ItemStack(Material.AIR));
                    }
                    int index = 0;
                    for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                        String owner = pl.getName();
                        headMeta.setOwner(owner);
                        headMeta.setDisplayName(ChatColor.YELLOW + owner);
                        head.setItemMeta(headMeta);
                        kickInv.setItem(index, head);
                        index++;
                    }
                    kickInv.setItem(53, zpet);
                    p.openInventory(kickInv);
                    p.updateInventory();
                }
            } else if (clicked.getType() == Material.BARRIER) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + "BAN PLAYER")) {
                    getLogger().info("Someone decided to ban a player");
                    e.setCancelled(true);
                    p.closeInventory();
                    for (int i = 0; i < 54; i++) {
                        banInv.setItem(i, new ItemStack(Material.AIR));
                    }
                    int index = 0;
                    for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                        String owner = pl.getName();
                        headMeta.setOwner(owner);
                        headMeta.setDisplayName(ChatColor.YELLOW + owner);
                        head.setItemMeta(headMeta);
                        banInv.setItem(index, head);
                        index++;
                    }
                    banInv.setItem(53, zpet);
                    p.openInventory(banInv);
                    p.updateInventory();
                }
            } else if (clicked.getType() == Material.GREEN_WOOL) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + "UNBAN PLAYER")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    for (int i = 0; i < 53; i++) {
                        unbanInv.setItem(i, new ItemStack(Material.AIR));
                    }
                    if (!(bannedPlayers.size() == 0)) {
                        for (int i = 0; i < bannedPlayers.size(); i++) {
                            String owner = bannedPlayers.get(i);
                            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                            SkullMeta meta = (SkullMeta) head.getItemMeta();
                            meta.setOwner(owner);
                            meta.setDisplayName(ChatColor.YELLOW + owner);
                            head.setItemMeta(meta);
                            unbanInv.setItem(i, head);
                        }

                    }
                    unbanInv.setItem(53, zpet);
                    p.openInventory(unbanInv);
                }
            }
        } else if (inv.getName().equals(kickInv.getName())) {
            if (clicked.getType() == Material.PLAYER_HEAD) {
                e.setCancelled(true);
                SkullMeta meta = (SkullMeta) clicked.getItemMeta();
                String owner = meta.getOwner();
                for (Player player : Bukkit.getServer().getOnlinePlayers())
                    if (player.getName().equals(owner)) {
                        player.kickPlayer(ChatColor.RED + "Admin decided to kick you... Sorry :P");
                        for (int i = 0; i < 53; i++) {
                            kickInv.setItem(i, new ItemStack(Material.AIR));
                        }
                        int index = 0;
                        for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                            SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                            String o = pl.getName();
                            headMeta.setOwner(o);
                            headMeta.setDisplayName(ChatColor.YELLOW + o);
                            head.setItemMeta(headMeta);
                            kickInv.setItem(index, head);
                            index++;
                        }
                        for (HumanEntity he : inv.getViewers()) {
                            Player pla = (Player) he;
                            pla.updateInventory();
                        }
                        getLogger().info("Kick disappear was succesful");
                    }
            }
            if (clicked.getType() == Material.SLIME_BALL) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "BACK")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.openInventory(adminInv);
                }
            }
        } else if (inv.getName().equals(banInv.getName())) {
            if (clicked.getType() == Material.PLAYER_HEAD) {
                e.setCancelled(true);
                SkullMeta meta = (SkullMeta) clicked.getItemMeta();
                String owner = meta.getOwner();
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (player.getName().equals(owner)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ban " + owner);
                        bannedPlayers.add(0, owner);
                        for (int i = 0; i < 53; i++) {
                            banInv.setItem(i, new ItemStack(Material.AIR));
                        }
                        int index = 0;
                        for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                            SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                            String o = pl.getName();
                            headMeta.setOwner(o);
                            headMeta.setDisplayName(ChatColor.YELLOW + o);
                            head.setItemMeta(headMeta);
                            banInv.setItem(index, head);
                            index++;
                        }
                        for (HumanEntity he : inv.getViewers()) {
                            Player pla = (Player) he;
                            pla.updateInventory();
                        }
                    }
                }

            }
            if (clicked.getType() == Material.SLIME_BALL) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "BACK")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.openInventory(adminInv);
                }
            }
        } else if (inv.getName().equals(unbanInv.getName())) {
            if (clicked.getType() == Material.PLAYER_HEAD) {
                e.setCancelled(true);
                SkullMeta meta = (SkullMeta) clicked.getItemMeta();
                String owner = meta.getOwner();
                getLogger().info(owner);
                for (OfflinePlayer player : Bukkit.getServer().getOfflinePlayers()) {
                    if (player.getName().equals(owner)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pardon " + owner);
                        bannedPlayers.remove(owner);
                        for (int i = 0; i < 53; i++) {
                            unbanInv.setItem(i, new ItemStack(Material.AIR));
                        }
                        if (!(bannedPlayers.size() == 0)) {
                            for (int i = 0; i < bannedPlayers.size(); i++) {
                                String owne = bannedPlayers.get(i);
                                ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                                SkullMeta met = (SkullMeta) head.getItemMeta();
                                met.setOwner(owne);
                                met.setDisplayName(ChatColor.YELLOW + owne);
                                head.setItemMeta(met);
                                unbanInv.setItem(i, head);
                            }
                        }
                        for (HumanEntity he : inv.getViewers()) {
                            Player pla = (Player) he;
                            pla.updateInventory();
                        }
                    }
                }
            }
            if (clicked.getType() == Material.SLIME_BALL) {
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "BACK")) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.openInventory(adminInv);
                }
            }
        } else getLogger().info("bohuzel");
    }

    public void ticTacReset() {
        for (int i = 0; i < 53; i++) {
            ttt.setItem(i, new ItemStack(Material.OAK_BOAT));
        }
        ItemStack reset = new ItemStack(Material.BARRIER);
        ItemMeta meta = reset.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "RESET");
        reset.setItemMeta(meta);
        ttt.setItem(53, reset);
    }


}