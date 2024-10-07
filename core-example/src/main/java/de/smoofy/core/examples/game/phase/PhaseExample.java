package de.smoofy.core.examples.game.phase;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 14:04
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.api.game.phase.IPhaseHandler;

public class PhaseExample {

    private final IPhaseHandler phaseHandler = Core.instance().phaseHandler();

    public PhaseExample() {
        new LobbyPhase();
        new IngamePhase();

        phaseHandler.currentPhase("Lobby");
    }

    public void test() {
        if (phaseHandler.currentPhase().phaseName().equals("Lobby")) {
            phaseHandler.currentPhase("Ingame");
        } else {
            phaseHandler.currentPhase("Lobby");
        }
    }

}
