package org.plaxerstudios.it.plaxerhub.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.plaxerstudios.it.plaxerhub.Utils;

public class LevaMessage implements Listener {
    @EventHandler
    public void onQuitPlayer(PlayerQuitEvent event) {
        // get player
        Player p = event.getPlayer();

        if(Utils.getboolean("QuitMSG.Enable") == false){

        }else {
            event.setQuitMessage(Utils.getString("QuitMSG.Message")
                    .replace("&", "§")
                    .replace("%player%", p.getName()));
        }

    }
}
