package de.smoofy.core.base.time;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 28.09.24, 00:04
 */

import de.smoofy.core.api.player.ICorePlayer;
import de.smoofy.core.api.time.ITimeHandler;
import de.smoofy.core.api.time.TimeUnit;
import org.apache.commons.lang3.NotImplementedException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeHandlerImpl implements ITimeHandler {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy, HH:mm:ss");

    @Override
    public String timeNow() {
        return this.localDateTime().format(this.dateTimeFormatter);
    }

    @Override
    public String format(LocalDateTime localDateTime) {
        return localDateTime.format(this.dateTimeFormatter);
    }

    @Override
    public String format(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return localDateTime.format(dateTimeFormatter);
    }

    @Override
    public String timeIn(int years, int months, int days, int hours, int minutes, int seconds) {
        LocalDateTime localDateTime = this.localDateTime().plusYears(years).plusMonths(months).plusDays(days).plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
        return localDateTime.format(this.dateTimeFormatter);
    }

    @Override
    public String timeIn(int time, TimeUnit timeUnit) {
        LocalDateTime localDateTime;
        switch (timeUnit) {
            case YEARS -> localDateTime = this.localDateTime().plusYears(time);
            case MONTHS -> localDateTime = this.localDateTime().plusMonths(time);
            case WEEKS -> localDateTime = this.localDateTime().plusWeeks(time);
            case DAYS -> localDateTime = this.localDateTime().plusDays(time);
            case HOURS -> localDateTime = this.localDateTime().plusHours(time);
            case MINUTES -> localDateTime = this.localDateTime().plusMinutes(time);
            case SECONDS -> localDateTime = this.localDateTime().plusSeconds(time);
            default -> throw new IllegalStateException("Unexpected value: " + timeUnit);
        }
        return localDateTime.format(this.dateTimeFormatter);
    }

    @Override
    public String timeBack(int years, int months, int days, int hours, int minutes, int seconds) {
        LocalDateTime localDateTime = this.localDateTime().minusYears(years).minusMonths(months).minusDays(days).minusHours(hours).minusMinutes(minutes).minusSeconds(seconds);
        return localDateTime.format(this.dateTimeFormatter);
    }

    @Override
    public String timeBack(int time, TimeUnit timeUnit) {
        LocalDateTime localDateTime;
        switch (timeUnit) {
            case YEARS -> localDateTime = this.localDateTime().minusYears(time);
            case MONTHS -> localDateTime = this.localDateTime().minusMonths(time);
            case WEEKS -> localDateTime = this.localDateTime().minusWeeks(time);
            case DAYS -> localDateTime = this.localDateTime().minusDays(time);
            case HOURS -> localDateTime = this.localDateTime().minusHours(time);
            case MINUTES -> localDateTime = this.localDateTime().minusMinutes(time);
            case SECONDS -> localDateTime = this.localDateTime().minusSeconds(time);
            default -> throw new IllegalStateException("Unexpected value: " + timeUnit);
        }
        return localDateTime.format(this.dateTimeFormatter);
    }

    @Override
    public String zero() {
        return "-1";
    }

    @Override
    public String today() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd. MM yyyy");
        LocalDateTime localDateTime = this.localDateTime();
        return localDateTime.format(dateTimeFormatter);
    }

    @Override
    public String timeString(String time) {
        if (time.equals(this.zero())) return "§4§lPERMANENT";
        return time;
    }

    @Override
    public boolean later(String time) {
        if (time.equals(this.zero())) return true;
        LocalDateTime localDateTime = LocalDateTime.parse(time, dateTimeFormatter);
        return localDateTime.isAfter(this.localDateTime());
    }

    @Override
    public boolean beforeToday(String time) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd. MM yyyy");
        LocalDateTime localDateTime = LocalDateTime.parse(time, dateTimeFormatter);
        return localDateTime.isBefore(this.localDateTime());
    }

    @Override
    public String timeZone(ICorePlayer player) {
        throw new NotImplementedException("Method not implemented yet.");
    }


    @Override
    public LocalDateTime localDateTime(long millis) {
        return Instant.ofEpochMilli(millis).atZone(ZoneId.of("Europe/Berlin")).toLocalDateTime();
    }

    @Override
    public DateTimeFormatter dateTimeFormatter() {
        return this.dateTimeFormatter;
    }

    private LocalDateTime localDateTime() {
        return LocalDateTime.now(ZoneId.of("Europe/Berlin"));
    }


}
