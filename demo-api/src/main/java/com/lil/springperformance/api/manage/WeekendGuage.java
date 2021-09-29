package com.lil.springperformance.api.manage;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class WeekendGuage {

    public WeekendGuage(MeterRegistry registry) {
        registry.gauge("weekend.wait.in.days", Tags.empty(), weekendCountdown());
    }

    private int weekendCountdown() {
        LocalDate today = LocalDate.now();
        int dow = DayOfWeek.from(today).getValue();
        if (dow < 5) {
            return 5-dow;
        }
        return 0;
    }

}
