package org.plaxerstudios.it.plaxerhub.LikeCoral.BlockDestroy;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;
import org.plaxerstudios.it.plaxerhub.Utils;

public class OnBlockPlace implements Listener {
    private int count;

    private static Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);

    @EventHandler
    public void onPlayerPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        event.getBlockPlaced();

        Location pos1 = Utils.getConfigLocation("pos1");
        Location pos2 = Utils.getConfigLocation("pos2");

        if (Utils.isLocationInProtectedArea(event.getBlock().getLocation(), pos1, pos2)) {
            long removeBlockAfter = 80L;
            long timePerAnimation = removeBlockAfter / 9L;
            for (int i = 0; i < 9; i++) {
                int finalI = i;
                Bukkit.getScheduler().runTaskLater(instance, () -> (new SendBlockAnimation()).sendPacket(event.getBlock(), finalI), timePerAnimation * i);

            }
            Bukkit.getScheduler().runTaskLater(instance, () -> {
                event.getBlock().setType(Material.AIR);
            }, removeBlockAfter);
        }



    }
    private PlaxerHub instance;
    public OnBlockPlace(PlaxerHub instance) {
        this.instance = instance;
    }



}
