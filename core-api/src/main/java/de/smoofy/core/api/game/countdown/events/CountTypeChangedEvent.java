/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.game.countdown.events;

import de.smoofy.core.api.event.BukkitEvent;
import de.smoofy.core.api.game.countdown.CountType;
import de.smoofy.core.api.game.countdown.ICountdown;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class CountTypeChangedEvent extends BukkitEvent {

    private final Object key;
    private final ICountdown countdown;
    private final CountType newType;

}
