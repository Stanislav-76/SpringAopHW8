package ru.gb.hw;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogPerformanceAspect {
    @Pointcut("within(@ru.gb.hw.LogPerformance *)")
    public void beansAnnotatedWith() {

    }

    @Pointcut("@annotation(ru.gb.hw.LogPerformance)")
    public void methodsAnnotatedWith() {

    }
    @Around("beansAnnotatedWith() || methodsAnnotatedWith()")
    public Object methodExecutionTimeAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("ClassName: " + joinPoint.getSignature().getDeclaringType() + " MethodName: " + joinPoint.getSignature().getName() + " выполнился за " + elapsedTime + " миллисекунд");
        return result;

    }

}
