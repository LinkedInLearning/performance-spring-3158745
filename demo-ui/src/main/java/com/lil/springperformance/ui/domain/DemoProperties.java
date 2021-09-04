package com.lil.springperformance.ui.domain;

import java.util.Properties;

public class DemoProperties {

    private Properties runtimeProperties;

    public void setRuntimeProperties(Properties props) {
        this.runtimeProperties = props;
    }

    public Properties getRuntimeProperties() {
        return runtimeProperties;
    }
}