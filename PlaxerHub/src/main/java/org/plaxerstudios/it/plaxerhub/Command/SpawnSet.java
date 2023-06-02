package org.plaxerstudios.it.plaxerhub.Command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.plaxerstudios.it.plaxerhub.Utils;

public class SpawnSet implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender p, Command command, String s, String[] strings) {
        if(p.hasPermission("plaxerhub.setSpawn")){
            if(p instanceof Player){
                Location loc = ((Player) p).getLocation();

                Utils.setInt( "Spawn.x" ,loc.getBlockX());
                Utils.setInt( "Spawn.y" ,loc.getBlockY());
                Utils.setInt( "Spawn.z" ,loc.getBlockZ());
                Utils.setInt( "Spawn.Pitch" , (int) loc.getPitch());
                Utils.setInt( "Spawn.Yaw" , (int) loc.getYaw());
                Utils.setString("Spawn.World" , loc.getWorld().getName());
                Utils.saveconfig();

                p.sendMessage("§r§lPLAXER§b§lHUB §7 Spawn location saved");

            }

        }else{
            p.sendMessage("§r§lPLAXER§b§lHUB §c You do not have permission to use this command!");
        }
        return false;
    }
}
