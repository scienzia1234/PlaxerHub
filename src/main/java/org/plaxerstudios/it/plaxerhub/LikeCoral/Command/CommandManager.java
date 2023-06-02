package org.plaxerstudios.it.plaxerhub.LikeCoral.Command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.plaxerstudios.it.plaxerhub.LikeCoral.Database.CommandBlockPlaced;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;
import org.plaxerstudios.it.plaxerhub.Utils;

public class CommandManager implements CommandExecutor {
    private static Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);
    private Location pos2;
    private Location pos1;
    @Override
    public boolean onCommand(CommandSender p, Command command, String s, String[] args) {
        if(!(p instanceof Player)){
            return true;
        }
        if(!p.hasPermission("plaxerhub.block")){
            return true;

        }
        if(p.hasPermission("plaxerhub.block")){
            Player player = (Player) p;
            if(args.length == 0){
                p.sendMessage("§r§lPLAXER§b§lHUB §cCommand:"+
                        "\n§d- §7/block gui" +
                        "\n§d- §7/block stats" +
                        "\n§d- §7/block pos1" +
                        "\n§d- §7/block pos2");
                return true;
            }

            if(args[0].equalsIgnoreCase("gui")){
                String cmd = "Crgui";
                Utils.executeCommand((Player) p, cmd);



            }else if(args[0].equalsIgnoreCase("stats")){
                CommandBlockPlaced.getBlockPlaced(p, args);


            }else if(args[0].equalsIgnoreCase("pos1")){
                if(player.isFlying()){
                    player.sendMessage("§r§lPLAXER§b§lHUB §7 per settare la posizione non devi volare!");
                    return true;
                }
                p.sendMessage("§r§lPLAXER§b§lHUB §aPosizione 1 settata corretamente!");
                pos1 = player.getLocation();
                plugin.getConfig().set("pos1", pos1.serialize());
                plugin.saveConfig();
                plugin.reloadConfig();
                Utils.setblockAndRemove(player, 400);
            }else if(args[0].equalsIgnoreCase("pos2")) {
                if(player.isFlying()){
                    player.sendMessage("§r§lPLAXER§b§lHUB §7 per settare la posizione non devi volare!");
                    return true;
                }
                p.sendMessage("§r§lPLAXER§b§lHUB §aPosizione 2 settata corretamente!");
                pos2 = player.getLocation();
                plugin.getConfig().set("pos2", pos2.serialize());
                plugin.saveConfig();
                plugin.reloadConfig();
                Utils.setblockAndRemove(player, 400);


            }

        }
        return false;
    }
}
