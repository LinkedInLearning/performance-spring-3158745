package com.lil.springperformance.api.manage;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class WeekendHealth implements HealthIndicator {

    private final String message_key = "Play time?";

    @Override
    public Health health() {
        if (isWeekend()) {
            return Health.outOfService().withDetail(message_key, "Yes!").build();
        }
        return Health.up().withDetail(message_key, "Nope.").build();
    }

    private boolean isWeekend() {
        LocalDate today = LocalDate.now();
        int dow = DayOfWeek.from(today).getValue();
        switch (dow) {
            case 0:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }

    }
}
