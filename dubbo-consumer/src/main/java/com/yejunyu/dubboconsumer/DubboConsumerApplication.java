package com.yejunyu.dubboconsumer;

import com.alibaba.csp.sentinel.adapter.dubbo.fallback.DubboFallbackRegistry;
import com.alibaba.dubbo.rpc.RpcResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yejunyu.dubboconsumer.controller")
public class DubboConsumerApplication {

    public static void main(String[] args) {
        DubboFallbackRegistry.setConsumerFallback((a, b, ex) -> {
            return new RpcResult("自定义的异常fallback: " + ex.getClass().getTypeName());
        });
        SpringApplication.run(DubboConsumerApplication.class, args);

    }

}
