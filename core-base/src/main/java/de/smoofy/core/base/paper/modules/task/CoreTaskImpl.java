package de.smoofy.core.base.paper.modules.task;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 16:02
 */

import de.smoofy.core.api.module.tasks.ICoreTask;
import de.smoofy.core.base.bootstrap.PaperBootstrap;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class CoreTaskImpl implements ICoreTask {

    @Override
    public BukkitTask repeat(Runnable runnable, long delay, long period) {
        return Bukkit.getScheduler().runTaskTimer(PaperBootstrap.instance(), runnable, delay, period);
    }

    @Override
    public BukkitTask repeatAsync(Runnable runnable, long delay, long period) {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(PaperBootstrap.instance(), runnable, delay, period);
    }

    @Override
    public BukkitTask later(Runnable runnable, long delay) {
        return Bukkit.getScheduler().runTaskLater(PaperBootstrap.instance(), runnable, delay);
    }

    @Override
    public BukkitTask laterAsync(Runnable runnable, long delay) {
        return Bukkit.getScheduler().runTaskLaterAsynchronously(PaperBootstrap.instance(), runnable, delay);
    }

    @Override
    public BukkitTask async(Runnable runnable) {
        return Bukkit.getScheduler().runTaskAsynchronously(PaperBootstrap.instance(), runnable);
    }

    @Override
    public BukkitTask nextTick(Runnable runnable) {
        return Bukkit.getScheduler().runTask(PaperBootstrap.instance(), runnable);
    }
}
