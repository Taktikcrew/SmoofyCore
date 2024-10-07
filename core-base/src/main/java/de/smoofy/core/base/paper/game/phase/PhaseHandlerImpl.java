package de.smoofy.core.base.paper.game.phase;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 11:53
 */

import com.google.common.collect.Lists;
import de.smoofy.core.api.game.phase.IPhaseHandler;
import de.smoofy.core.api.game.phase.Phase;
import de.smoofy.core.api.game.phase.event.PhaseChangedEvent;
import org.bukkit.Bukkit;

import java.util.List;

public class PhaseHandlerImpl implements IPhaseHandler {

    private final List<Phase> phases = Lists.newArrayList();

    private Phase currentPhase;

    @Override
    public Phase currentPhase() {
        return this.currentPhase;
    }

    @Override
    public void currentPhase(Phase phase) {
        if (this.phases.contains(phase)) {
            Phase oldPhase = null;
            if (this.currentPhase != null) {
                oldPhase = this.currentPhase;
                this.currentPhase.onDisable();
            }
            this.currentPhase = phase;
            this.currentPhase.onEnable();
            Bukkit.getPluginManager().callEvent(new PhaseChangedEvent(oldPhase, this.currentPhase));
        }
    }

    @Override
    public void currentPhase(String phase) {
        this.currentPhase(this.phase(phase));
    }

    @Override
    public void cache(Phase phase) {
        if (!this.phases.contains(phase)) {
            this.phases.add(phase);

        }
    }

    @Override
    public Phase phase(String name) {
        return this.phases.stream().filter(phase -> phase.phaseName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Phase> phases() {
        return this.phases;
    }
}
