package org.plaxerstudios.it.plaxerhub.LikeCoral.BlockDestroy;

import org.bukkit.block.Block;

public class BlockID {
    public static int getBlockEntityId(Block block) {
        return (block.getX() & 0xFFF) << 20 | (block
                .getZ() & 0xFFF) << 8 | block
                .getY() & 0xFF;
    }
}
