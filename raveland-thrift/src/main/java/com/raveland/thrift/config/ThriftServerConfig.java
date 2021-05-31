package com.raveland.thrift.config;

import com.raveland.thrift.server.ThriftServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

/**
 * todo
 *
 * @author shay
 * @date 2021/5/31
 **/
@RequiredArgsConstructor
public class ThriftServerConfig implements CommandLineRunner {

    private final ThriftServer thriftServer;

    @Override
    public void run(String... args) throws Exception {
        thriftServer.start();
    }
}
