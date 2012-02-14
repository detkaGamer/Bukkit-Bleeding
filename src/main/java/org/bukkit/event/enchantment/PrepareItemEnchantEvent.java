package org.bukkit.event.enchantment;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * Called when an ItemStack is inserted in an enchantment table - can be called multiple times
 */
@SuppressWarnings("serial")
public class PrepareItemEnchantEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Block table;
    private final ItemStack item;
    private final int[] levelsOffered;
    private final int bonus;
    private boolean cancel;
    private final Player enchanter;

    public PrepareItemEnchantEvent(final Player enchanter, final Block table, final ItemStack item, final int[] levelsOffered, final int bonus) {
        this.enchanter = enchanter;
        this.table = table;
        this.item = item;
        this.levelsOffered = levelsOffered;
        this.bonus = bonus;
        this.cancel = false;
    }

    /**
     * Gets the player enchanting the item
     *
     * @returns enchanting player
     */
    public Player getEnchanter() {
        return enchanter;
    }

    /**
     * Gets the block being used to enchant the item
     *
     * @return the block used for enchanting
     */
    public Block getEnchantBlock() {
        return table;
    }

    /**
     * Gets the item to be enchanted (can be modified)
     *
     * @return ItemStack of item
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     * Get list of offered exp level costs of the enchantment (modify values to change offer)
     * @return experience level costs offered
     */
    public int[] getExpLevelCostsOffered() {
        return levelsOffered;
    }

    /**
     * Get enchantment bonus in effect - corresponds to number of bookshelves
     * @return enchantment bonus
     */
    public int getEnchantmentBonus() {
        return bonus;
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
