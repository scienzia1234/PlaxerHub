package org.plaxerstudios.it.plaxerhub.LikeCoral.BlockDestroy;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;
import org.plaxerstudios.it.plaxerhub.Utils;

public class OnBlockBreack implements Listener {
    private static Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);

    @EventHandler
    public void onPlayerPlace(BlockBreakEvent event) {
        Player player = event.getPlayer(); // Get player
        Location pos1 = Utils.getConfigLocation("pos1");
        Location pos2 = Utils.getConfigLocation("pos2");


        if (Utils.isLocationInProtectedArea(event.getBlock().getLocation(), pos1, pos2)) {
            player.sendMessage("§r§lPLAXER§b§lHUB §cNon puoi rompere i blocchi!");
            event.setCancelled(true);
        }



    }

}
