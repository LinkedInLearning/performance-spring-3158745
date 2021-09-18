package com.lil.springperformance.client.manage;

import com.lil.springperformance.client.DemoClientApplication;
import com.lil.springperformance.client.domain.DemoProperties;
import com.lil.springperformance.client.domain.HeapObjects;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DemoManager {

    private static Logger logger = LoggerFactory.getLogger(DemoManager.class);

    public static List<Double> list = new ArrayList<>();

    private Random random = new Random();

    private static HeapObjects heapTester;

    public DemoManager() {
        logger.info("In constructor" );
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(new NewTask(), 2, TimeUnit.SECONDS);
        //initializeMemoryExamples();
        //initializeThreadExamples();
    }

    public void initializeMemoryExamples() {
        logger.info("Initializing memory examples" );
        if (true) {
            //heapTester.initStaticList();
            //heapTester.initOpenConnection();
        }
    }

    private void initializeThreadExamples() {
        int a = 5; //Integer.getInteger(props.getRuntimeProperties().getProperty("thread.count", "5"));
        int b = 10; //Integer.getInteger(props.getRuntimeProperties().getProperty("thread.load", "10"));
        int c = 2; //Integer.getInteger(props.getRuntimeProperties().getProperty("thread.time", "2"));
        for (int x=0; x<5; x++) {
            Thread t = new Thread(new HelloRunnable(x));
            t.setName("DemoThread-" + x);
            t.start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        }
    }

    class NewTask implements Runnable {

        @Override
        public void run() {
            logger.info(String.valueOf(heapTester.getStaticListLength()));
            //heapTester.initStaticList();
            //logger.info("" + heapTester.getStaticListLength());
            logger.info("Task completed" );
        }

    }


    class HelloRunnable implements Runnable {

        private int instanceCount;

        private HeapObjects stackTester;

        HelloRunnable(int counter) {
            instanceCount = counter;
        }

        public void run() {
            while(true) {
                stackTester = new HeapObjects();
                stackTester.initInstanceList();
                stackTester.initOpenConnection();
            }
        }

    }

}


