package org.bukkit.event.block;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * Called when a block is broken by a player.
 * <p />
 * Note:
 * Plugins wanting to simulate a traditional block drop should set the block to air and utilise their own methods for determining
 *   what the default drop for the block being broken is and what to do about it, if anything.
 * <p />
 * If a Block Break event is cancelled, the block will not break.
 */
public class BlockBreakEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private boolean cancel;
    private List<ItemStack> drops;

    public BlockBreakEvent(final Block theBlock, final Player player, List<ItemStack> drops) {
        super(theBlock);
        this.player = player;
        this.cancel = false;
    }

    /**
     * Gets the Player that is breaking the block involved in this event.
     *
     * @return The Player that is breaking the block involved in this event
     */
    public Player getPlayer() {
        return player;
    }
    
    public List<ItemStack> getDrops() {
        return drops;
    }
    
    public void setDrops(List<ItemStack> drops) {
        this.drops = drops;
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
