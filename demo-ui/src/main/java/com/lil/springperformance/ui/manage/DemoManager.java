package com.lil.springperformance.ui.manage;

import com.lil.springperformance.ui.domain.DemoProperties;
import com.lil.springperformance.ui.domain.HeapObject;

public class DemoManager {

    private DemoProperties props;

    public DemoManager(DemoProperties props) {
        this.props = props;
        initializeLoad();
        initializeView();
    }

    private void initializeLoad() {
        int a = 5; //Integer.getInteger(props.getRuntimeProperties().getProperty("thread.count", "5"));
        int b = 10; //Integer.getInteger(props.getRuntimeProperties().getProperty("thread.load", "10"));
        int c = 2; //Integer.getInteger(props.getRuntimeProperties().getProperty("thread.time", "2"));
        for (int x=0; x<5; x++) {
            Thread t = new Thread(new HelloRunnable(x));
            t.setName("DemoThread-" + x);
            t.start();
        }
    }

    private void initializeView() {

    }

    class HelloRunnable implements Runnable {

        private int instanceCount;

        HelloRunnable(int counter) {
            instanceCount = counter;
        }

        public void run() {
            while(true) {
                HeapObject a = new HeapObject();
                String b = new String("helloHeap");
            }
        }

    }

}


