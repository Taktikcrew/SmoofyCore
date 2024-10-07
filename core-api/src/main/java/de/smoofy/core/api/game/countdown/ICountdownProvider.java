package de.smoofy.core.api.game.countdown;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 11:29
 */

import de.smoofy.core.api.annotation.DoNotUse;

public interface ICountdownProvider {

    /**
     * Create a new countdown.
     *
     * @param key the key of the countdown.
     * @param countType the type of the countdown.
     * @param seconds the duration of the countdown.
     * @return the created {@link ICountdown}.
     */
    ICountdown create(Object key, CountType countType, int seconds);

    /**
     * Get a countdown by the key.
     *
     * @param key the key of the countdown.
     * @return the {@link ICountdown} or null if not found.
     */
    ICountdown countdown(Object key);

    /**
     * Cache a countdown.
     *
     * @param countdown the countdown to cache.
     */
    @DoNotUse void cache(ICountdown countdown);

}