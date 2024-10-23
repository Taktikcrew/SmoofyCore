/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.game;

public interface IGameConfiguration {

    /**
     * Get the amount of minimum players.
     *
     * @return the amount of minimum players
     */
    int minPlayers();

    /**
     * Get the amount of maximum players.
     *
     * @return the amount of maximum players
     */
    int maxPlayers();

    /**
     * Get the amount of teams.
     *
     * @return the amount of teams
     */
    int teams();

    /**
     * Get the amount of players per team.
     *
     * @return the amount of players per team
     */
    int teamSize();

}
