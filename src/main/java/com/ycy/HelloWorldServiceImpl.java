package com.ycy;

import com.ycy.interfaces.HelloWorldService;

/**
 * Created by ycy on 16/3/3.
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface {

    public String sayHello(String s) {
        return "hello" + s;
    }
}
