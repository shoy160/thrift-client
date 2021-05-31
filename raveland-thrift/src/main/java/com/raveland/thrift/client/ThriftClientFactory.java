package com.raveland.thrift.client;

import com.raveland.core.lang.Action;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TProtocol;

/**
 * client factory
 *
 * @author shay
 * @date 2021/5/28
 **/
public interface ThriftClientFactory {
    /**
     * 创建客户端
     *
     * @param <T>   client
     * @param clazz class
     * @return client
     */
    <T extends TServiceClient> T create(Class<T> clazz);

    /**
     * 使用客户端(使用完自动关闭)
     *
     * @param clazz  class
     * @param action action
     * @param <T>    client type
     */
    default <T extends TServiceClient> void use(Class<T> clazz, Action<T> action) {
        T client = null;
        try {
            client = create(clazz);
            if (client != null) {
                action.invoke(client);
            }
        } finally {
            if (client != null) {
                TProtocol protocol = client.getInputProtocol();
                if (protocol != null && protocol.getTransport().isOpen()) {
                    protocol.getTransport().close();
                }
                protocol = client.getOutputProtocol();
                if (protocol != null && protocol.getTransport().isOpen()) {
                    protocol.getTransport().close();
                }
            }
        }
    }
}
