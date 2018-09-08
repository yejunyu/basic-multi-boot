package com.yejunyu.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yejunyu.dubboprovider.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yejunyu
 * @Date: 2018/9/8
 * @Email: yyyejunyu@gmail.com
 */
@RestController
public class DemoConsumerController {

    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345"
    )
    private DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return demoService.sayHello(name);
    }
}
