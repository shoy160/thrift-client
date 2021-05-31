package com.raveland.consumer;

import com.raveland.client.UserCmd;
import com.raveland.client.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;

/**
 * todo
 *
 * @author shay
 * @date 2021/5/28
 **/
public class RavelandConsumer {
    public static void main(String[] args) throws TException {
        TSocket socket = new TSocket("localhost", 9125);
        socket.open();

        TBinaryProtocol protocol = new TBinaryProtocol(socket);
        UserService.Client client = new UserService.Client(protocol);
        int result = client.add(new UserCmd());
        System.out.println(result);
    }
}
