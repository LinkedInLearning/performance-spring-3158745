package com.lil.springperformance.client.domain;

import java.io.Serializable;

public class Device implements Serializable {
    private int id;
    private String name;
    private String display;
    private boolean isUp;

    public Device() { }

    public Device(int id, String name, String display, boolean isUp) {
        this.id = id;
        this.name = name;
        this.display = display;
        this.isUp = isUp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay() {
        return name;
    }

    public void setDisplay(String name) {
        this.name = name;
    }

    public boolean getIsUp() {
        return isUp;
    }

    public void setIsUp(boolean isUp) {
        this.isUp = isUp;
    }
}

