package org.bukkit.event.entity;

import org.bukkit.entity.Entity;

@SuppressWarnings("serial")
public class EntityCombustByEntityEvent extends EntityCombustEvent {
    private final Entity combuster;

    public EntityCombustByEntityEvent(final Entity combuster, final Entity entity, final int duration) {
        super(entity, duration);
        this.combuster = combuster;
    }

    /**
     * The combuster can be a WeatherStorm a Blaze, or an Entity holding a FIRE_ASPECT enchanted item.
     *
     * @return the Entity that set the combustee alight.
     */
    public Entity getCombuster() {
        return combuster;
    }
}
