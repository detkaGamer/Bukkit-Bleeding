package org.bukkit.event.world;

import org.bukkit.block.Block;
import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Called when the world attempts to create a matching end to a portal
 */
@SuppressWarnings("serial")
public class PortalCreateEvent extends WorldEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final ArrayList<Block> blocks;

    public PortalCreateEvent(final Collection<Block> blocks, final World world) {
        super(world);
        this.blocks = new ArrayList<Block>(blocks);
        this.cancel = false;
    }

    /**
     * Gets an array list of all the blocks associated with the created portal
     *
     * @return array list of all the blocks associated with the created portal
     */
    public ArrayList<Block> getBlocks() {
        return this.blocks;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
