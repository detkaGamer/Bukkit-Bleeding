package org.bukkit.event.entity;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

@SuppressWarnings("serial")
public class EntityCombustByBlockEvent extends EntityCombustEvent {
    private final Block combuster;

    public EntityCombustByBlockEvent(final Block combuster, final Entity entity, final int duration) {
        super(entity, duration);
        this.combuster = combuster;
    }

    /**
     * The combuster can be lava or a block that is on fire.
     * <p />
     * WARNING: block may be null.
     *
     * @return the Block that set the combustee alight.
     */
    public Block getCombuster() {
        return combuster;
    }
}
