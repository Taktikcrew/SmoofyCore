package de.smoofy.core.base.paper.game.countdown;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 07.10.24, 11:52
 */

import com.google.common.collect.Lists;
import de.smoofy.core.api.game.countdown.CountType;
import de.smoofy.core.api.game.countdown.ICountdown;
import de.smoofy.core.api.game.countdown.ICountdownProvider;

import java.util.List;

public class CountdownProviderImpl implements ICountdownProvider {

    private final List<ICountdown> countdowns = Lists.newArrayList();

    @Override
    public ICountdown create(Object key, CountType countType, int seconds) {
        return new CountdownImpl(key, countType, seconds);
    }

    @Override
    public ICountdown countdown(Object key) {
        return this.countdowns.stream().filter(countdown -> countdown.key().equals(key)).findFirst().orElse(null);
    }

    @Override
    public void cache(ICountdown countdown) {
        this.countdowns.add(countdown);
    }
}
