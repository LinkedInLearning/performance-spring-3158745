package com.lil.springperformance.client.aop;

import com.lil.springperformance.client.domain.CpuLoader;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class PerformanceMonitorConfiguration {

    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }

    @Pointcut("execution(public String com.lil.springperformance.client.controller.DemoController.*(..))")
    public void monitor() { }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.lil.springperformance.client.aop.PerformanceMonitorConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }

    @Bean
    public CustomPerformanceMonitorInterceptor customPerformanceMonitorInterceptor() {
        return new CustomPerformanceMonitorInterceptor(true);
    }

    @Pointcut("execution(public String com.lil.springperformance.client.domain.CpuLoader.expensiveCalculation(..))")
    public void customMonitor() { }

    @Bean
    public Advisor customPerformanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.lil.springperformance.client.aop.PerformanceMonitorConfiguration.customMonitor()");
        return new DefaultPointcutAdvisor(pointcut, customPerformanceMonitorInterceptor());
    }
}
