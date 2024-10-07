package de.smoofy.core.api.game;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 11:23
 */

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
