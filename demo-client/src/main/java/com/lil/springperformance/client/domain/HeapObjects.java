package com.lil.springperformance.client.domain;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class HeapObjects {

    public static final List<Double> staticList = new ArrayList<>();

    private List<Double> instanceList = new ArrayList<>();

    private List<String> instanceList2 = new ArrayList<>();

    public void initStaticList() {
        for (int i = 0; i < 1000000000; i++) {
            staticList.add(Math.random());
        }
    }

    public int getStaticListLength() {
        return staticList.size();
    }

    public void initInstanceList() {
        for (int i = 0; i < 10000000; i++) {
            instanceList.add(Math.random());
        }
        for (int i = 0; i < 100000; i++) {
            instanceList2.add("String" + i);
        }
    }

    public void initOpenConnection() {
        try {
            URL url = new URL("http://kathyflint.com");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            byte[] bytes = is.readAllBytes();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
