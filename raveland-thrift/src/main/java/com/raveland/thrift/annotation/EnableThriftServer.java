package com.raveland.thrift.annotation;

import com.raveland.thrift.config.ThriftServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启Thrift服务
 *
 * @author shay
 * @date 2021/5/31
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(value = {ThriftServerConfig.class})
public @interface EnableThriftServer {
}
