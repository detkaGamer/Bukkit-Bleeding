package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Called when a players level changes
 */
@SuppressWarnings("serial")
public class PlayerLevelChangeEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final int oldLevel;
    private final int newLevel;

    public PlayerLevelChangeEvent(final Player player, final int oldLevel, final int newLevel) {
         super(player);
         this.oldLevel = oldLevel;
         this.newLevel = newLevel;
    }

    /**
     * Gets the old level of the player
     *
     * @return The old level of the player
     */
    public int getOldLevel() {
        return oldLevel;
    }

    /**
     * Gets the new level of the player
     *
     * @return The new (current) level of the player
     */
    public int getNewLevel() {
        return newLevel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
