package org.bukkit.event.player;

import org.bukkit.QuitReason;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Called when a player gets kicked from the server
 */
public class PlayerKickEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private String leaveMessage;
    private String kickReason;
    private Boolean cancel;
    private QuitReason quitReason;

    @Deprecated
    public PlayerKickEvent(final Player playerKicked, final String kickReason, final String leaveMessage) {
        this(playerKicked, kickReason, leaveMessage, QuitReason.KICKED);
    }

    public PlayerKickEvent(final Player playerKicked, final String kickReason, final String leaveMessage, final QuitReason quitReason) {
        super(playerKicked);
        this.kickReason = kickReason;
        this.leaveMessage = leaveMessage;
        this.quitReason = quitReason;
        this.cancel = false;
    }

    /**
     * Gets the reason why the player is getting kicked
     *
     * @return string kick reason
     */
    public String getReason() {
        return kickReason;
    }

    /**
     * Gets the leave message to send to all online players
     *
     * @return string leave message
     */
    public String getLeaveMessage() {
        return leaveMessage;
    }

    /**
     * Gets the reason the server kicked the player. This
     * method returns an enum, intended for use by other
     * plugins. Use getReason() to obtain a text version.
     *
     * @return QuitReason quit reason
     */
    public QuitReason getQuitReason() {
        return quitReason;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * Sets the reason why the player is getting kicked
     *
     * @param kickReason kick reason
     */
    public void setReason(String kickReason) {
        this.kickReason = kickReason;
    }

    /**
     * Sets the leave message to send to all online players
     *
     * @param leaveMessage leave message
     */
    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}