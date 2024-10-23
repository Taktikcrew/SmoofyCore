/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.paper.game;

import de.smoofy.core.api.game.IGameConfiguration;

public record GameConfigurationImpl(int minPlayers, int maxPlayers, int teams, int teamSize) implements IGameConfiguration {

    @Override
    public int minPlayers() {
        return this.minPlayers;
    }

    @Override
    public int maxPlayers() {
        return this.maxPlayers;
    }

    @Override
    public int teams() {
        return this.teams;
    }

    @Override
    public int teamSize() {
        return this.teamSize;
    }
}
