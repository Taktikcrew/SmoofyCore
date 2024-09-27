package de.smoofy.core.api.time;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 27.09.24, 23:27
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface ITimeHandler {

    /**
     * Get the current time.
     *
     * @return the current time
     */
    String timeNow();

    /**
     * Get the current time.
     *
     * @param localDateTime the LocalDateTime
     * @return the current time formatted
     */
    String format(LocalDateTime localDateTime);

    /**
     * Get the current time.
     *
     * @param localDateTime the time
     * @param dateTimeFormatter the format
     * @return the current time in the format
     */
    String format(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter);

    /**
     * Get the time in the future.
     *
     * @param years   the years
     * @param months  the months
     * @param days    the days
     * @param hours   the hours
     * @param minutes the minutes
     * @param seconds the seconds
     * @return the time
     */
    String timeIn(int years, int months, int days, int hours, int minutes, int seconds);

    /**
     * Get the time in the future.
     *
     * @param time     the time
     * @param timeUnit the time unit
     * @return the time
     */
    String timeIn(int time, TimeUnit timeUnit);

    /**
     * Get the time in the past.
     *
     * @param years   the years
     * @param months  the months
     * @param days    the days
     * @param hours   the hours
     * @param minutes the minutes
     * @param seconds the seconds
     * @return the time
     */
    String timeBack(int years, int months, int days, int hours, int minutes, int seconds);

    /**
     * Get the time in the past.
     *
     * @param time     the time
     * @param timeUnit the time unit
     * @return the time
     */
    String timeBack(int time, TimeUnit timeUnit);

    /**
     * Get the zero time.
     *
     * @return "-1"
     */
    String zero();

    /**
     * Get the date of today. (dd. MM yyyy)
     *
     * @return the date of today
     */
    String today();

    /**
     * Get the time as a string. Interesting for a punish system.
     *
     * @param time the time
     * @return the time as a string
     */
    String timeString(String time);

    /**
     * @param time the time
     * @return true if the time is after now, otherwise false
     */
    boolean later(String time);

    /**
     * @param time the time
     * @return true if the time is before now, otherwise false
     */
    boolean beforeToday(String time);

    // todo
    /**
     * Get the time zone in players language.
     *
     * @return the time zone
     */
    String timeZone(/*ICorePlayer player*/);

    /**
     * Get the LocalDateTime of millis.
     *
     * @return the {@link LocalDateTime}
     */
    LocalDateTime localDateTime(long millis);

    /**
     * Get the {@link DateTimeFormatter}.
     *
     * @return the {@link DateTimeFormatter} (dd MM yyyy, HH:mm:ss)
     */
    DateTimeFormatter dateTimeFormatter();

}
