package org.plaxerstudios.it.plaxerhub.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.plaxerstudios.it.plaxerhub.Utils;

public class JoinTeleportToHub implements Listener {
    @EventHandler
    public void TeleportToHub(PlayerJoinEvent event) {

        Player p = event.getPlayer();

        int x =  Utils.getInt("Spawn.x");
        int y =  Utils.getInt("Spawn.y");
        int z =  Utils.getInt("Spawn.z");
        int Pitch =  Utils.getInt("Spawn.Pitch");
        int yaw =  Utils.getInt("Spawn.Yaw");
        String world = Utils.getString("Spawn.World");


        Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, Pitch);
        p.teleport(loc);


        p.sendMessage("§r§lPLAXER§b§lHUB §7 You have been teleported to the Spawn");


    }

}
