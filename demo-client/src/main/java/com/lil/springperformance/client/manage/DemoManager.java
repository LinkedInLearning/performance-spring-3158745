package com.lil.springperformance.client.manage;

import com.lil.springperformance.client.DemoClientApplication;
import com.lil.springperformance.client.domain.DemoProperties;
import com.lil.springperformance.client.domain.HeapObjects;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DemoManager {

    private static Logger logger = LoggerFactory.getLogger(DemoManager.class);

    private HeapObjects heapLeaker = new HeapObjects();

    public DemoManager(DemoProperties props) {
        logger.info("Running in demo mode: " + props.getDemoMode());
        switch (props.getDemoMode()) {
            case "visual-vm": { initializeVvmConditions(); break; }
            default: { }
        }
    }

    private void initializeVvmConditions() {
        ScheduledExecutorService heapLoadExecService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService threadLoadExecService = Executors.newSingleThreadScheduledExecutor();
        heapLoadExecService.schedule(new HeapLoaderTask(), 10, TimeUnit.SECONDS);
        threadLoadExecService.schedule(new ThreadLoaderTask(), 20, TimeUnit.SECONDS);
    }

    class HeapLoaderTask implements Runnable {

        @Override
        public void run() {
            logger.info("Loading up interesting heap things to look at in Visual VM." );
            heapLeaker.initStaticList();
        }

    }

    class ThreadLoaderTask implements Runnable {

        @Override
        public void run() {
            logger.info("Loading up interesting thread things to look at in Visual VM." );
            for(int x = 0; x<10;x++)  {
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
            try {
                Thread.sleep(3000 * instanceCount);
            } catch (Exception e) { }
            String x = heapLeaker.expensiveCalculation(100000);
        }

    }

}


