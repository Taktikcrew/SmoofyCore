package de.smoofy.core.base.velocity.listener;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 04.10.24, 15:54
 */

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import de.smoofy.core.api.Core;

public class PostLoginListener {

    @Subscribe
    public void onPostLogin(PostLoginEvent event) {
        Core.instance().corePlayerProvider().init(event.getPlayer().getUniqueId());
    }

}
