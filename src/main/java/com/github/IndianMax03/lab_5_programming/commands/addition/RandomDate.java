package com.github.indianMax03.lab_5_programming.commands.addition;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class RandomDate {
    public static ZonedDateTime getDate() {

        int max = 2021;
        final int year = (int) (Math.random() * ++max) + 1;

        max = 11;
        final int month = (int) (Math.random() * ++max) + 1;

        max = 27;
        final int day = (int) (Math.random() * ++max) + 1;

        LocalDate date = LocalDate.of(year, month, day);
        LocalTime time = LocalTime.of(month, day);
        ZoneId zone = ZoneId.of("Europe/Moscow");

        return ZonedDateTime.of(date, time, zone);
    }
}
