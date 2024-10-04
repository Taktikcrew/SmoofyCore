package de.smoofy.core.base.database;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 04.10.24, 16:49
 */

import de.smoofy.core.base.player.CorePlayer;
import dev.httpmarco.evelon.MariaDbLayer;
import dev.httpmarco.evelon.Repository;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class DatabaseProvider {

    @Getter
    @Accessors(fluent = true)
    private static DatabaseProvider instance;

    private final Repository<CorePlayer> corePlayerRepository;

    public DatabaseProvider() {
        instance = this;

        this.corePlayerRepository = Repository.build(CorePlayer.class).withLayer(MariaDbLayer.class).build();
    }
}