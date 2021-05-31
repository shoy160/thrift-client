package com.raveland.thrift.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * thrift 配置
 *
 * @author shay
 * @date 2021/5/28
 **/
@Getter
@Setter
@Component
@Configuration
@ConfigurationProperties(prefix = "raveland.thrift")
public class ThriftConfig {
    private Integer port = 8090;
    private String host = "localhost";
}
