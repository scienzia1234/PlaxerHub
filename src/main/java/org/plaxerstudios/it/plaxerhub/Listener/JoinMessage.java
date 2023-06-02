package org.plaxerstudios.it.plaxerhub.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.plaxerstudios.it.plaxerhub.Utils;


public class JoinMessage implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        //If Enable this event is true run...

        if(Utils.getboolean("JoinMSG.Enable") == false){


        }else {

            // get player
            Player p = event.getPlayer();

            // Event join message
            // Config string: JoinMSG.Message
            event.setJoinMessage(Utils.getString("JoinMSG.Message")
                    .replace("&", "§")
                    .replace("%player%", p.getName()));
        }
    }
}
