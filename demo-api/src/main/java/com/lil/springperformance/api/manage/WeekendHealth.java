package com.lil.springperformance.api.manage;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;


@Component
public class WeekendHealth implements HealthIndicator {

    /*
    curl -i -X POST -H 'Content-Type: application/json' -d '{"configuredLevel": "TRACE"}' http://localhost:9092/actuator/loggers/com.lil.springperformance.api.DemoApiApplication
    */

    private final String message_key = "Play Time";

    @Override
    public Health health() {
        if (isWeekend()) {
            //return Health.outOfService().withDetail(message_key, "Yes!").build();
            return Health.up().withDetail(message_key, "Yes!").build();
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
        }
        return false;
    }
}
