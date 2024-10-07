package de.smoofy.core.api.game.phase;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 11:39
 */

import de.smoofy.core.api.annotation.DoNotUse;

import java.util.List;

public interface IPhaseHandler {

    /**
     * Get the current phase.
     *
     * @return the current {@link Phase}
     */
    Phase currentPhase();

    /**
     * Set the current phase.
     *
     * @param phase the new phase
     */
    void currentPhase(Phase phase);

    /**
     * Set the current phase.
     *
     * @param phase the new phase
     */
    void currentPhase(String phase);

    /**
     * Add a phase to the cache.
     *
     * @param phase the phase
     */
    @DoNotUse void cache(Phase phase);

    /**
     * Get a phase from the cache.
     *
     * @param name the name of the phase.
     * @return the {@link Phase} of the name or null if not found
     */
    Phase phase(String name);

    /**
     * Get all cached phases.
     *
     * @return a list of all cached {@link Phase}s
     */
    List<Phase> phases();
}
