package com.raveland.provider;

import com.alibaba.boot.nacos.config.autoconfigure.NacosConfigAutoConfiguration;
import com.raveland.core.Constants;
import com.raveland.thrift.annotation.EnableThriftServer;
import com.raveland.web.RavelandApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * todo
 *
 * @author shay
 * @date 2021/5/31
 **/
@SpringBootApplication(exclude = NacosConfigAutoConfiguration.class)
@EnableThriftServer
@ComponentScan(basePackages = Constants.BASE_PACKAGES)
public class ProviderApplication {
    public static void main(String[] args) {
        RavelandApplication.run("thrift-provider", ProviderApplication.class, args);
    }
}
