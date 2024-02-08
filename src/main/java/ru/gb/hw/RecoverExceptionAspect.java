package ru.gb.hw;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class RecoverExceptionAspect{

    @Pointcut("@annotation(ru.gb.hw.RecoverException)")
    public void methodsAnnotatedWith() {

    }

//    @AfterThrowing(value = "methodsAnnotatedWith()", throwing = "exception")
//    public Object exceptionAspect(JoinPoint joinPoint, Exception exception) throws Throwable {
//        Class<?> classObj = joinPoint.getTarget().getClass();
//        Class<? extends Exception> classObjEx = exception.getClass();
//        Method[] methods = classObj.getMethods();
//        String metod = joinPoint.getSignature().getName();
//        Method methodx = classObj.getMethod(metod); //метод класса
////            System.out.println("Метод " + methodx);
//        Annotation annotation =  methodx.getAnnotation(RecoverException.class);
//        RecoverException recoverException = (RecoverException)annotation ;
//        Class<? extends RuntimeException>[] classes = recoverException.noRecoverFor(); // классы параметров аннотации
//        if(Arrays.stream(classes).toList().contains(classObjEx)){
//            return exception;
//        }
//        return null;
//    }

    @Around("methodsAnnotatedWith()")
    public Object exceptionAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object returnValue = joinPoint.proceed();
            return returnValue;
        } catch (Throwable e) {
            Class classObj = joinPoint.getTarget().getClass();
            Class classObjEx = e.getClass();
            String metod = joinPoint.getSignature().getName();
            Method method = classObj.getMethod(metod); //метод класса
//            System.out.println("Метод " + methodx);
            Annotation annotation =  method.getAnnotation(RecoverException.class);
            RecoverException recoverException = (RecoverException)annotation ;
            Class<? extends RuntimeException>[] classes = recoverException.noRecoverFor(); // классы параметров аннотации
            if(!Arrays.stream(classes).toList().contains(classObjEx)){
                return null;
            }
            return e;
        }
    }


    }
