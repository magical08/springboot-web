package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:Log
 * Package:com.itheima.anno
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/13 17:59
 * @Version 1.0
 */

//加上元注解
@Retention(RetentionPolicy.RUNTIME)  //  指定Log注解什么时候生效
@Target(ElementType.METHOD)   //指定Log注解作用在哪些地方
public @interface Log {
}
