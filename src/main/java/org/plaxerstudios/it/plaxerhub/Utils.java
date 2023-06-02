package org.plaxerstudios.it.plaxerhub;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public class Utils {

    private static Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);

    public static String getString(String path){

        // Get String in the config using path
        // Example: "Ex.msg"
        String message = plugin.getConfig().getString(path);

        // Return message = String
        return message;
    }

    public static int getInt(String path){

        // Get Int in the config using path
        // Example: "Ex.msg"
        int message = plugin.getConfig().getInt(path);

        // Return message = String
        return message;
    }

    public static boolean getboolean(String path){

        // Get Boolean in the config using path
        // Example: true
        Boolean message = plugin.getConfig().getBoolean(path);

        // Return message = Boolean
        return message;
    }

    public static void setInt(String path, int in){
        // Set config a path the int = in
        plugin.getConfig().set(path, in);
    }
    public static void setString(String path, String string){
        // Set config a path the string = string
        plugin.getConfig().set(path, string);
    }

    public static void saveconfig(){
        plugin.saveConfig();
        plugin.reloadConfig();
    }





    public static Location getConfigLocation(String key) {
        FileConfiguration config = plugin.getConfig();

        double x = config.getDouble(key + ".x");
        double y = config.getDouble(key + ".y");
        double z = config.getDouble(key + ".z");
        World world = Bukkit.getWorld(config.getString(key + ".world"));

        return new Location(world, x, y, z);
    }
    public static boolean isLocationInProtectedArea(Location location, Location pos1, Location pos2) {
        double[] minMaxX = getMinMax(pos1.getX(), pos2.getX());
        double[] minMaxY = getMinMax(pos1.getY(), pos2.getY());
        double[] minMaxZ = getMinMax(pos1.getZ(), pos2.getZ());

        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        return x >= minMaxX[0] && x <= minMaxX[1]
                && y >= minMaxY[0] && y <= minMaxY[1]
                && z >= minMaxZ[0] && z <= minMaxZ[1];
    }

    private static double[] getMinMax(double a, double b) {
        double min = Math.min(a, b);
        double max = Math.max(a, b);
        return new double[]{min, max};
    }
    public static void executeCommand(Player player, String command) {
        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            SimpleCommandMap commandMap = (SimpleCommandMap) field.get(Bukkit.getServer());

            CommandSender sender = player != null ? player : Bukkit.getConsoleSender();
            commandMap.dispatch(sender, command);
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Impossibile eseguire il comando: " + command, e);
        }
    }


    public static void setblockAndRemove(Player player, int dalay){
        final Block block = player.getLocation().subtract(0, 1, 0).getBlock();
        block.setType(Material.GOLD_BLOCK);

        new BukkitRunnable() {
            @Override
            public void run() {

                block.setType(Material.AIR);

            }
        }.runTaskLater(plugin, dalay); // 20 ticks = 1 secondo, quindi 40 ticks = 2 secondi
    }


    public static void removeblock(Player player, BlockPlaceEvent event, int dalay){
        final Block block = event.getBlockPlaced();

        new BukkitRunnable() {
            @Override
            public void run() {

                block.setType(Material.AIR);


            }
        }.runTaskLater(plugin, dalay); // 20 ticks = 1 secondo, quindi 40 ticks = 2 secondi



    }




//new PacketPlayOutBlockBreakAnimation(-player.getEntityId(), position, stage)

}
