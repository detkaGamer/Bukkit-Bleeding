package org.bukkit.event.inventory;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * Called when an ItemStack is successfully smelted in a furnace.
 */
@SuppressWarnings("serial")
public class FurnaceSmeltEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Block furnace;
    private final ItemStack source;
    private ItemStack result;
    private boolean cancel;

    public FurnaceSmeltEvent(final Block furnace, final ItemStack source, ItemStack result) {
        super();
        this.furnace = furnace;
        this.source = source;
        this.result = result;
        this.cancel = false;
    }

    /**
     * Gets the block for the furnace involved in this event
     *
     * @return the block of the furnace
     */
    public Block getFurnace() {
        return furnace;
    }

    /**
     * Gets the smelted ItemStack for this event
     *
     * @return smelting source ItemStack
     */
    public ItemStack getSource() {
        return source;
    }

    /**
     * Gets the resultant ItemStack for this event
     *
     * @return smelting result ItemStack
     */
    public ItemStack getResult() {
        return result;
    }

    /**
     * Sets the resultant ItemStack for this event
     *
     * @param result new result ItemStack
     */
    public void setResult(ItemStack result) {
        this.result = result;
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
