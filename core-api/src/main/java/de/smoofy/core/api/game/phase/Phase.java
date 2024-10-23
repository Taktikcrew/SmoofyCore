/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.game.phase;

import de.smoofy.core.api.Core;
import de.smoofy.core.api.annotation.DoNotUse;
import de.smoofy.core.api.game.countdown.ICountdownProvider;
import lombok.Getter;
import lombok.experimental.Accessors;

public abstract class Phase {

    public ICountdownProvider countdownProvider = Core.instance().countdownProvider();

    @Getter
    @Accessors(fluent = true)
    private final String phaseName;

    public Phase(String phaseName) {
        this.phaseName = phaseName;

        Core.instance().phaseHandler().cache(this);
    }

    /**
     * Called when the phase starts.
     *
     * @hidden this method is not intended to be used by the end user
     */
    @DoNotUse public abstract void onEnable();

    /**
     * Called when the phase stopps.
     *
     * @hidden this method is not intended to be used by the end user
     */
    @DoNotUse public abstract void onDisable();

}
