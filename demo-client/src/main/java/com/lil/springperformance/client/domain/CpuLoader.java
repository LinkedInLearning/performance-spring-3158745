package com.lil.springperformance.client.domain;

import java.util.ArrayList;
import java.util.List;

public class CpuLoader {

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
                //Appended the Prime number to the String
                primeNumbers = primeNumbers + i + " ";
            }
        }
        return primeNumbers;
    }

}
