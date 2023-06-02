package org.plaxerstudios.it.plaxerhub.LikeCoral.Database;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CommandBlockPlaced {
    private static Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);

    public static void getBlockPlaced(CommandSender sender, String[] args) {

        String playerName = args[1];

        Player player = plugin.getServer().getPlayer(playerName);
        if (player == null) {


        }else {

            UUID playerUUID = player.getUniqueId();
            int blocksPlaced = getBlocksPlaced(playerUUID);

            sender.sendMessage("");
            sender.sendMessage("");
            sender.sendMessage("§bPlayer: §e" + playerName);
            sender.sendMessage("§b- §dHave placed: §e" + blocksPlaced  + " §dBlock.");
            sender.sendMessage("");
            sender.sendMessage("");

        }


    }



    private static int getBlocksPlaced(UUID playerUUID) {
        try {
            PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement("SELECT BLOCKS_PLACED FROM DATA WHERE UUID = ?");
            statement.setString(1, playerUUID.toString());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() ? resultSet.getInt("BLOCKS_PLACED") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
