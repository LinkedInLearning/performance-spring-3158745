package com.lil.springperformance.client.manage;

import com.lil.springperformance.client.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DemoManager {

    private static Logger logger = LoggerFactory.getLogger(DemoManager.class);

    private DemoProperties demoProps;
    private HeapLoader heapLeaker = new HeapLoader();
    private HeapLoader[] heapLoad;

    private CpuLoader cpuLoader = new CpuLoader();

    public DemoManager(DemoProperties props) {
        logger.info("Running in demo mode: " + props.getDemoMode());
        switch (props.getDemoMode()) {
            case "visual-vm": {
                this.heapLoad = new HeapLoader[5];
                initializeVvmHeapConditions(false);
                initializeVvmThreadConditions();
                break;
            }
            case "challenge-jvm": {
                this.heapLoad = new HeapLoader[2];
                initializeVvmHeapConditions(true);
                initializeVvmThreadConditions();
                break;
            }
            case "glowroot": {
                initializeGrBackgroundConditions(7000);
                break;
            }
            default: { }
        }
    }

    private void initializeVvmHeapConditions(boolean leakLoad) {
        ScheduledExecutorService heapLoadExecService = Executors.newSingleThreadScheduledExecutor();
        heapLoadExecService.schedule(new HeapLoaderTask(leakLoad), 10, TimeUnit.SECONDS);
    }

    private void initializeVvmThreadConditions() {
        ScheduledExecutorService threadLoadExecService = Executors.newSingleThreadScheduledExecutor();
        threadLoadExecService.schedule(new ThreadLoaderTask(), 10, TimeUnit.SECONDS);
    }

    private void initializeGrBackgroundConditions(int sleepTime) {
        logger.info("Setting up interesting transaction things to look at in Glowroot.");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) { }
    }

    class HeapLoaderTask implements Runnable {

        private boolean leakLoad;

        HeapLoaderTask(boolean leak) {
            if (leak) {
                logger.info("Pssssst - look here for the challenge leak :)");
                heapLeaker.initStaticDoubleList();
                heapLeaker = null;
            };
        };

        @Override
        public void run() {
            logger.info("Loading up interesting heap things to look at in Visual VM." );
            for(int x = 0; x < heapLoad.length; x++) {
                logger.info("Adding 1 to the heap.");
                heapLoad[x] = new HeapLoader();
                heapLoad[x].initInstanceDoubleList();
                try {
                    Thread.sleep(5000);
                } catch (Exception e) { }
                if (x > 0) {
                    logger.info("Taking 1 from the heap.");
                    heapLoad[x-1] = null;
                }
            }
            logger.info("Taking 1 from the heap.");
            heapLoad[heapLoad.length] = null;
        }

    }

    class ThreadLoaderTask implements Runnable {

        @Override
        public void run() {
            logger.info("Loading up interesting thread things to look at in Visual VM." );
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
            try {
                Thread.sleep(3000 * instanceCount);
            } catch (Exception e) { }
            //cpuLoader.expensiveCalculation(100000);
            cpuLoader.expensiveCalculation(instanceCount * 50000);
        }

    }

}


