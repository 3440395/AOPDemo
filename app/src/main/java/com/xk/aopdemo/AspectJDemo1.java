package com.xk.aopdemo;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by xuekai on 2017/6/28.
 */

@Aspect//这个类被Aspect注解之后，这个类就会在编译的时候被植入过去
public class AspectJDemo1 {
    private static final String TAG = "AspectJDemo1";

    //before 表示在后面通配符配对的方法之前执行（execution），after同理
    @Before("execution(* com.xk.aopdemo.MainActivity.Test**())")
    public void beforeOnTestxxx(JoinPoint joinPoint){
        Signature kind = joinPoint.getSignature();
            Log.e(TAG,"beforeOnTestxxx"+kind);
    }

    //around，可以理解为before和after的结合
    @Around("execution(* com.xk.aopdemo.MainActivity.Test**())")
    public void aroundOnTestxxx(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Log.e(TAG,"aroundOnBefore"+proceedingJoinPoint.getSignature());
        proceedingJoinPoint.proceed();
        Log.e(TAG,"aroundOnAfter"+proceedingJoinPoint.getSignature());
    }

}
