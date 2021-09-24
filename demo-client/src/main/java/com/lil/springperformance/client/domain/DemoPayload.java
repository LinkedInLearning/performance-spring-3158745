package com.lil.springperformance.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoPayload {

    private String type;
    private Value value;

    public DemoPayload() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DemoPayload{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
