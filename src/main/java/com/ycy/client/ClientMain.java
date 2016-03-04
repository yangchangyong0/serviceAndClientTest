package com.ycy.client;

/**
 * Created by ycy on 16/3/3.
 */
import com.ycy.interfaces.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ClientMain {
    /**
     * 调用Hello服务
     * @param args
     */
    public static void main(String[] args) {
        try {
            //设置调用的服务器为本地，端口为7911
            TTransport transport = new TSocket("localhost", 7911);
            transport.open();
            //设置传输协议为TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            System.out.println(client.sayHello("mnin"));  ;
            transport.close();

        } catch (TTransportException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}


