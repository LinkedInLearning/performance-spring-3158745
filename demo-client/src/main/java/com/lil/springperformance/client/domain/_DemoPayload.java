package com.lil.springperformance.client.domain;

import org.springframework.beans.factory.annotation.Value;

public class _DemoPayload {

    private String id;
    private String content;

    public _DemoPayload() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(Value value) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "id='" + id + '\'' +
                ", content=" + content +
                '}';
    }
}
