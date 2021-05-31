package com.raveland.thrift.annotation;

import java.lang.annotation.*;

/**
 * todo
 *
 * @author shay
 * @date 2021/5/28
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ThriftService {
    String name() default "";
}
