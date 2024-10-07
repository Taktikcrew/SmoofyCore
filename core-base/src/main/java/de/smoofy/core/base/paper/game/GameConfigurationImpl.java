package de.smoofy.core.base.paper.game;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 11:44
 */

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
