package org.plaxerstudios.it.plaxerhub.LikeCoral.Database;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;
import org.plaxerstudios.it.plaxerhub.Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerBlockListener implements Listener {


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        Location pos1 = Utils.getConfigLocation("pos1");
        Location pos2 = Utils.getConfigLocation("pos2");
        if (Utils.isLocationInProtectedArea(event.getBlock().getLocation(), pos1, pos2)) {

            if (!isPlayerRegistered(playerUUID)) {
                registerPlayer(playerUUID);
            }


            updateBlocksPlaced(playerUUID);
        }



    }

    private boolean isPlayerRegistered(UUID playerUUID) {
        try {
            PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement("SELECT UUID FROM DATA WHERE UUID = ?");
            statement.setString(1, playerUUID.toString());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void registerPlayer(UUID playerUUID) {
        try {
            PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement("INSERT INTO DATA (UUID, BLOCKS_PLACED) VALUES (?, 0)");
            statement.setString(1, playerUUID.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateBlocksPlaced(UUID playerUUID) {
        try {
            PreparedStatement selectStatement = DatabaseUtils.getConnection().prepareStatement("SELECT BLOCKS_PLACED FROM DATA WHERE UUID = ?");
            selectStatement.setString(1, playerUUID.toString());
            ResultSet resultSet = selectStatement.executeQuery();
            int blocksPlaced = resultSet.next() ? resultSet.getInt("BLOCKS_PLACED") : 0;

            PreparedStatement updateStatement = DatabaseUtils.getConnection().prepareStatement("UPDATE DATA SET BLOCKS_PLACED = ? WHERE UUID = ?");
            updateStatement.setInt(1, blocksPlaced + 1);
            updateStatement.setString(2, playerUUID.toString());
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
