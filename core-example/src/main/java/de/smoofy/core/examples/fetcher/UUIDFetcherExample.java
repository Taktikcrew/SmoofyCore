/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.fetcher;

import de.smoofy.core.api.Core;
import de.smoofy.core.api.fetcher.IUUIDFetcher;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.UUID;

public class UUIDFetcherExample {

    private final IUUIDFetcher uuidFetcher = Core.instance().uuidFetcher();

    public void testUUID(Player player, String name) {
        player.sendMessage(Component.text("UUID: " + uuidFetcher.uuid(name)));
    }

    public void testName(Player player, String uuid) {
        player.sendMessage(Component.text("Name: " + uuidFetcher.name(UUID.fromString(uuid))));
    }

}
