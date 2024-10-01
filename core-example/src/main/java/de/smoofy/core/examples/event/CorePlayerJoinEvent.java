package de.smoofy.core.examples.event;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 29.09.24, 22:46
 */

import de.smoofy.core.api.event.BukkitEvent;
import de.smoofy.core.api.player.ICorePlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class CorePlayerJoinEvent extends BukkitEvent {

    private final ICorePlayer player;

}
