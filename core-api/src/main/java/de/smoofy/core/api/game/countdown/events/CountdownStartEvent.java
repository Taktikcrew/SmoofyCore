package de.smoofy.core.api.game.countdown.events;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 11:27
 */

import de.smoofy.core.api.event.BukkitEvent;
import de.smoofy.core.api.game.countdown.ICountdown;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class CountdownStartEvent extends BukkitEvent {

    private final Object key;
    private final ICountdown countdown;

}
