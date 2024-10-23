/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.velocity.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import de.smoofy.core.api.Core;

public class DisconnectListener {

    @Subscribe
    public void onDisconnect(DisconnectEvent event) {
        var player = Core.instance().corePlayerProvider().corePlayer(event.getPlayer().getUniqueId());
        Core.instance().corePlayerProvider().update(player);
    }

}
