package com.lil.springperformance.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoPayload {

    private int id;
    private String message;

    public DemoPayload() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DemoPayload{" +
                "id='" + id + '\'' +
                ", message=" + message +
                '}';
    }
}
