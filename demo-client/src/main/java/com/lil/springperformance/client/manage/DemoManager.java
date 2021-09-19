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

    public DemoManager(String demoMode) {
        logger.info("Running in mode " + demoMode);
        DemoManager.heapTester = new HeapObjects();
        ScheduledExecutorService heapExecutorService = Executors.newSingleThreadScheduledExecutor();
        heapExecutorService.schedule(new HeapLoaderTask(), 10, TimeUnit.SECONDS);
        ScheduledExecutorService threadExecutorService = Executors.newSingleThreadScheduledExecutor();
        threadExecutorService.schedule(new ThreadLoaderTask(), 20, TimeUnit.SECONDS);

    }

    private void initializeThreadExamples() {
        for (int x=0; x<5; x++) {
            Thread t = new Thread(new CPULoaderTask(x));
            t.setName("DemoThread-" + x);
            t.start();
        }
    }

    class HeapLoaderTask implements Runnable {

        @Override
        public void run() {
            logger.info("Loading up static heap things," );
            DemoManager.heapTester.initStaticList();
            logger.info(String.valueOf(DemoManager.heapTester.getStaticListLength()) + " Doubles added to static list.");
            logger.info("Task completed" );
        }

    }

    class ThreadLoaderTask implements Runnable {

        @Override
        public void run() {
            for(int x = 0; x<5;x++)  {
                Thread t = new Thread(new CPULoaderTask(x));
                t.setName("DemoThread-" + x);
                t.start();
            }
        }
    }


    class CPULoaderTask implements Runnable {

        private int instanceCount;

        CPULoaderTask(int counter) {
            instanceCount = counter;
        }

        public void run() {
            logger.info("Loading up a new thread." );
            String x = DemoManager.heapTester.expensiveCalculation(100000);
            logger.info("result is " + x);
        }

    }

}


