package org.logblock.bukkit.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.logblock.Action;
import org.logblock.bukkit.LogBlock;
import org.logblock.entry.MainEntry;

import java.util.List;

public class EntityExplode extends BukkitListener<EntityExplodeEvent> {

    public EntityExplode(LogBlock lb)
    {
        super(lb);
    }

    @Override
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void listen(EntityExplodeEvent event) {
        List<Block> blocks = event.blockList();
        for (Block block : blocks ) {
            int x = block.getX();
            int y = block.getY();
            int z = block.getZ();
            this.lb.getDataStore().write(new MainEntry(Action.EXPLOSION, event.getEntityType().getName(), block.getTypeId(), block.getData(), Material.AIR.getId(), (byte) 0, x, y, z));
        }
    }

}
