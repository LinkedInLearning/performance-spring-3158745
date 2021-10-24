package com.lil.springperformance.client.domain;

import com.lil.springperformance.client.controller.DemoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CpuLoader {

    private static Logger logger = LoggerFactory.getLogger(CpuLoader.class);

    private List<Double> doubleInstanceList = new ArrayList<>();

    public String expensiveCalculation(int iterations) {
        for (int i = 0; i < 75000; i++) {
            doubleInstanceList.add(Math.random());
        }
        String  primeNumbers = "";
        for (int i = 1; i <= iterations; i++)
        {
            int counter=0;
            for(int num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                primeNumbers = primeNumbers + i + " ";
            }
        }
        return primeNumbers;
    }

}
