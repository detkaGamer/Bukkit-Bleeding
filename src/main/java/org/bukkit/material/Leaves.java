package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * Represents four types of leaves: {@link TreeSpecies#GENERIC}, {@link TreeSpecies#BIRCH}, {@link TreeSpecies#REDWOOD}, and {@link TreeSpecies#JUNGLE}.
 * </p>
 * The other types of leaves are represented by {@link Leaves2}.
 */
public class Leaves extends SimpleLeaves {
    public Leaves() {
        super(Material.LEAVES);
    }

    public Leaves(TreeSpecies species) {
        this();
        setSpecies(species);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Leaves(final int type) {
        super(type);
    }

    public Leaves(final Material type) {
        super(type);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Leaves(final int type, final byte data) {
        super(type, data);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Leaves(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public Leaves clone() {
        return (Leaves) super.clone();
    }
}
