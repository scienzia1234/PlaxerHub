package org.plaxerstudios.it.plaxerhub.Command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.plaxerstudios.it.plaxerhub.Utils;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender p, Command command, String s, String[] strings) {
        if(p instanceof Player){
            int x =  Utils.getInt("Spawn.x");
            int y =  Utils.getInt("Spawn.y");
            int z =  Utils.getInt("Spawn.z");
            int Pitch =  Utils.getInt("Spawn.Pitch");
            int yaw =  Utils.getInt("Spawn.Yaw");
            String world = Utils.getString("Spawn.World");


            Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, Pitch);
            ((Player) p).teleport(loc);

            p.sendMessage("§r§lPLAXER§b§lHUB §7 You have been teleported to the Spawn");

        }
        return false;
    }
}
