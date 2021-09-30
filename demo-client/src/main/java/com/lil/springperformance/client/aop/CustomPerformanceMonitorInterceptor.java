package com.lil.springperformance.client.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.util.Date;

public class CustomPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {

    private static long warnCount = 0;
    private static long warnThreshold = 10;

    public CustomPerformanceMonitorInterceptor(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log log) throws Throwable {
        String name = createInvocationTraceName(invocation);
        long start = System.currentTimeMillis();
        log.info("     Method " + name);
        try {
            return invocation.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            if (time > warnThreshold){
                log.warn("     Method execution longer than 10 ms!");
                log.info("     Custom warnings count: " + ++warnCount);
            }
        }
    }
}
