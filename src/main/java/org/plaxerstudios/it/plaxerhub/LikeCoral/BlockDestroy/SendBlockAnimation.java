package org.plaxerstudios.it.plaxerhub.LikeCoral.BlockDestroy;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SendBlockAnimation {
    public void sendPacket(Block block, int animationTime) {
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();
        PacketContainer packet = manager.createPacket(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);
        packet.getBlockPositionModifier().write(0, new BlockPosition(block.getX(), block.getY(), block.getZ()));
        packet.getIntegers().write(0, Integer.valueOf(BlockID.getBlockEntityId(block)));
        packet.getIntegers().write(1, Integer.valueOf(animationTime));
        for (Player receiver : Bukkit.getOnlinePlayers())
            manager.sendServerPacket(receiver, packet);
    }
}
