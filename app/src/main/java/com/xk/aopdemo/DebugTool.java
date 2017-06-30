package com.xk.aopdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xuekai on 2017/6/28.
 */

//这里定义了一个注解，让某个方法去使用它，然后在AspectJDemo1的debugToolMethod（）中去监听使用了该注解的方法
@Retention(RetentionPolicy.CLASS)//表示是编译型注解
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD})//表示可以用于方法和构造方法
public @interface DebugTool {
}
