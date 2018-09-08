package com.yejunyu.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Author: yejunyu
 * @Date: 2018/9/8
 * @Email: yyyejunyu@gmail.com
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DefaultDemoService implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
