package com.ycy.server;

import com.ycy.HelloWorldServiceImpl;
import com.ycy.interfaces.HelloWorldService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.protocol.TBinaryProtocol;


/**
 * Created by ycy on 16/3/3.
 */
public class ServerMain {
    public static void main(String[] args) {
        try {
            TProcessor processor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());
            //设置服务器端口为7911
            TServerSocket serverTransport = new TServerSocket(7911);
            //设置协议工厂为TBinaryProtocol.Factory
            Factory proFactory = new TBinaryProtocol.Factory();
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(processor);
            tArgs.protocolFactory(proFactory);
            //使用TSimpleServer
            TServer server = new TSimpleServer(tArgs);
            System.out.println("Start server on port 7911....");
            server.serve();

            serverTransport.close();
        } catch (Exception x) {
            x.printStackTrace();
        }
        System.out.println("done.");
    }
}
