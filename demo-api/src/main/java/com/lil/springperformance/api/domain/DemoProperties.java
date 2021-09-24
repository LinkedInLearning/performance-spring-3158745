package com.lil.springperformance.api.domain;

import java.util.Properties;

public class DemoProperties {

    private Properties runtimeProperties;

    public void setRuntimeProperties(Properties props) {
        this.runtimeProperties = props;
    }

    public Properties getRuntimeProperties() {
        return runtimeProperties;
    }

    public String getDemoMode() { return this.runtimeProperties.getProperty("demo.mode"); }
}