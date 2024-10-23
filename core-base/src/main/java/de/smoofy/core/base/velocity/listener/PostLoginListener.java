/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.velocity.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import de.smoofy.core.api.Core;

public class PostLoginListener {

    @Subscribe
    public void onPostLogin(PostLoginEvent event) {
        Core.instance().corePlayerProvider().init(event.getPlayer().getUniqueId());
    }

}
