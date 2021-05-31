package com.raveland.thrift.client;

import com.raveland.thrift.config.ThriftConfig;
import lombok.RequiredArgsConstructor;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;

/**
 * todo
 *
 * @author shay
 * @date 2021/5/28
 **/
@RequiredArgsConstructor
public class DefaultClientFactory implements ThriftClientFactory {
    private final ThriftConfig config;
    

    @Override
    public <T extends TServiceClient> T create(Class<T> clazz) {
        try {
            //todo 服务发现

            TSocket socket = new TSocket("localhost", 9125);
            socket.open();

            TBinaryProtocol protocol = new TBinaryProtocol(socket);
            return clazz
                    .getConstructor(TProtocol.class)
                    .newInstance(protocol);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
