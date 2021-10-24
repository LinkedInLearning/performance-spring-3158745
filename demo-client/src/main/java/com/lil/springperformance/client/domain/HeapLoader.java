package com.lil.springperformance.client.domain;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class HeapLoader {

    public static final List<Double> doubleLeakerList = new ArrayList<>();

    private List<Double> doubleInstanceList = new ArrayList<>();

    public void initStaticDoubleList() {
        for (int i = 0; i < 2000000; i++) {
            doubleLeakerList.add(Math.random());
        }
    }

    public int getStaticListLength() {
        return doubleLeakerList.size();
    }

    public void initInstanceDoubleList() {
        for (int i = 0; i < 1000000; i++) {
            doubleInstanceList.add(Math.random());
        }
    }

    public void initOpenConnection() {
        try {
            URL url = new URL("http://spring.io");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
