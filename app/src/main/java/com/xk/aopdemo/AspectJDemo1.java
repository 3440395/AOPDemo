package com.xk.aopdemo;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by xuekai on 2017/6/28.
 */

@Aspect//这个类被Aspect注解之后，这个类就会在编译的时候被植入过去
public class AspectJDemo1 {
    private static final String TAG = "AspectJDemo1";


    ///////////////////////////////////////////////////////////////////////////
    // 使用通配符，匹配方法，然后执行before、after、arounddengcaozuo
    ///////////////////////////////////////////////////////////////////////////
//    //before 表示在后面通配符配对的方法之前执行（execution），after同理
//    @Before("execution(* com.xk.aopdemo.MainActivity.Test**())")
//    public void beforeOnTestxxx(JoinPoint joinPoint){
//        Signature kind = joinPoint.getSignature();
//            Log.e(TAG,"beforeOnTestxxx"+kind);
//    }
//
//    //around，可以理解为before和after的结合
//    @Around("execution(* com.xk.aopdemo.MainActivity.Test**())")
//    public void aroundOnTestxxx(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        Log.e(TAG,"aroundOnBefore"+proceedingJoinPoint.getSignature());
//        proceedingJoinPoint.proceed();
//        Log.e(TAG,"aroundOnAfter"+proceedingJoinPoint.getSignature());
//    }


    ///////////////////////////////////////////////////////////////////////////
    // 使用自定义注解的方式，给需要插入代码的方法使用注解，然后。。。
    ///////////////////////////////////////////////////////////////////////////
    //以上是通过通配符去寻找方法，然后在方法前后插入代码，接下来是通过自定义注解的方式，定义切面，然后在切面的前后插入代码
    // 自定义注解
    @Pointcut("execution(@com.xk.aopdemo.DebugTool * *(..))")//定义一个切面，执行被DebugTool注解到的任意方法（ * *（。。））
    public void debugToolMethod(){//此时该方法就代表了被DebugTool注解的方法，但是该方法不会被执行，于是下面就可以尽情的使用他了
        Log.e(TAG,"debugToolMethod");//注意，这里并不会被执行
    }
    @Before("debugToolMethod()")
    public void beforeDebugToolMethod(JoinPoint joinPoint){
        Log.e(TAG,"beforeDebugToolMethod"+joinPoint.getSignature());
    }
    @After("debugToolMethod()")
    public void afterDebugToolMethod(){
        Log.e(TAG,"afterDebugToolMethod");
    }


    ///////////////////////////////////////////////////////////////////////////
    // 统一捕获异常
    ///////////////////////////////////////////////////////////////////////////
    @AfterThrowing(pointcut = "withincode(* com.xk.aopdemo.MainActivity.*(..))",throwing = "exception")
    public void dealException(JoinPoint jointPoint,Exception exception){
        LogUtil.d("AspectJDemo1-->dealException-->"+jointPoint+"  "+exception);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 正则表达式
    ///////////////////////////////////////////////////////////////////////////
    @Pointcut("execution(* *.t*())")
    public void cut1(){

    }
    @Pointcut("withincode(* com.xk.aopdemo.MainActivity.*(..))")
    public void cut2(){

    }
    @Pointcut("debugToolMethod() && cut2()")
    public void binding(){

    }
}
