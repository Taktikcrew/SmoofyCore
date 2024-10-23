/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.game.countdown;

public interface ICountdown {

    /**
     * Start the countdown.
     */
    void start();

    /**
     * Stop the countdown.
     */
    void stop();

    /**
     * Get the key of the countdown.
     *
     * @return the key of the countdown
     */
    Object key();

    /**
     * Get the count type of the countdown.
     *
     * @return the count type of the countdown
     */
    CountType countType();

    /**
     * Set the count type of the countdown.
     *
     * @param countType the count type
     */
    void countType(CountType countType);

    /**
     * Get the time of the countdown.
     *
     * @return the time of the countdown in seconds
     */
    int time();

    /**
     * Set the time of the countdown.
     *
     * @param time the time of the countdown in seconds
     */
    void time(int time);

}
