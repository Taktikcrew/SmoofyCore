/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.game.phase.event;

import de.smoofy.core.api.event.BukkitEvent;
import de.smoofy.core.api.game.phase.Phase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@AllArgsConstructor
public class PhaseChangedEvent extends BukkitEvent {

    private final Phase oldPhase;
    private final Phase newPhase;

}
