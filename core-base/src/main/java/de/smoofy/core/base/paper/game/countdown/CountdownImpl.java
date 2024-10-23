/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.paper.game.countdown;

import de.smoofy.core.api.Core;
import de.smoofy.core.api.game.countdown.CountType;
import de.smoofy.core.api.game.countdown.ICountdown;
import de.smoofy.core.api.game.countdown.events.CountdownStartEvent;
import de.smoofy.core.api.game.countdown.events.CountdownStopEvent;
import de.smoofy.core.api.game.countdown.events.CountdownTickEvent;
import de.smoofy.core.api.module.tasks.ICoreTask;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class CountdownImpl implements ICountdown {

    private final Object key;
    private final ICoreTask coreTask = Core.instance().coreTask();

    private CountType countType;
    private int time;

    private BukkitTask task;

    public CountdownImpl(Object key, CountType countType, int time) {
        this.key = key;
        this.countType = countType;
        this.time = time;

        Core.instance().countdownProvider().cache(this);
    }

    @Override
    public void start() {
        Bukkit.getPluginManager().callEvent(new CountdownStartEvent(this.key, this));
        this.task = this.coreTask.repeat(this::tick, 0, 20);
    }

    private void tick() {
        Bukkit.getPluginManager().callEvent(new CountdownTickEvent(this.key, this));
        if (this.countType.equals(CountType.COUNT)) {
            this.time--;
            if (this.time == 0) {
                Bukkit.getPluginManager().callEvent(new CountdownStopEvent(this.key, this));
                this.stop();
            }
        }
    }

    @Override
    public void stop() {
        this.task.cancel();
    }

    @Override
    public Object key() {
        return this.key;
    }

    @Override
    public CountType countType() {
        return this.countType;
    }

    @Override
    public void countType(CountType countType) {
        this.countType = countType;
    }

    @Override
    public int time() {
        return this.time;
    }

    @Override
    public void time(int time) {
        this.time = time;
    }
}
