package com.raveland.provider;

import com.raveland.client.UserService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * @author shay
 * @date 2021/05/28
 */
public class RavelandProvider {

    public static void main(String[] args) {
        try {
            UserService.Processor<UserService.Iface> processor =
                    new UserService.Processor<UserService.Iface>(new UserHandler());
            TServerTransport serverTransport = new TServerSocket(9125);
            TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverTransport)
                    .processor(processor);
            TServer server = new TThreadPoolServer(serverArgs);
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
