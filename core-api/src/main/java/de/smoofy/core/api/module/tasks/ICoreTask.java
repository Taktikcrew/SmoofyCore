package de.smoofy.core.api.module.tasks;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 16:00
 */

import org.bukkit.scheduler.BukkitTask;

public interface ICoreTask {

    /**
     * Repeat the task every x ticks.
     *
     * @param runnable the runnable
     * @param delay    the start delay
     * @param period   the repeat period
     * @return the {@link BukkitTask}
     */
    BukkitTask repeat(Runnable runnable, long delay, long period);

    /**
     * Repeat the task every x ticks.
     *
     * @param runnable the runnable
     * @param delay    the start delay
     * @param period   the repeat period
     * @return the {@link BukkitTask}
     */
    BukkitTask repeatAsync(Runnable runnable, long delay, long period);

    /**
     * Run the task after x ticks.
     *
     * @param runnable the runnable
     * @param delay    the delay
     * @return the {@link BukkitTask}
     */
    BukkitTask later(Runnable runnable, long delay);

    /**
     * Run the task after x ticks.
     *
     * @param runnable the runnable
     * @param delay    the delay
     * @return the {@link BukkitTask}
     */
    BukkitTask laterAsync(Runnable runnable, long delay);

    /**
     * Run the task async.
     *
     * @param runnable the runnable
     * @return the {@link BukkitTask}
     */
    BukkitTask async(Runnable runnable);

    /**
     * Run a task on the next server tick.
     *
     * @param runnable the runnable
     * @return the {@link BukkitTask}
     */
    BukkitTask nextTick(Runnable runnable);

}
