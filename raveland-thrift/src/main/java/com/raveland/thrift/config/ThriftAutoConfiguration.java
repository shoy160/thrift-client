package com.raveland.thrift.config;

import com.raveland.thrift.client.DefaultClientFactory;
import com.raveland.thrift.client.ThriftClientFactory;
import com.raveland.thrift.server.ThriftServer;
import com.raveland.thrift.server.impl.DefaultThriftServer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * todo
 *
 * @author shay
 * @date 2021/5/31
 **/
@Component
public class ThriftAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ThriftServer thriftServer(ThriftConfig config) {
        return new DefaultThriftServer(config);
    }

    @Bean
    @ConditionalOnMissingBean
    public ThriftClientFactory thriftClientFactory(ThriftConfig config) {
        return new DefaultClientFactory(config);
    }
}
