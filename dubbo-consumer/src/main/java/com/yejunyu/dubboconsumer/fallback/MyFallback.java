package com.yejunyu.dubboconsumer.fallback;

import com.alibaba.csp.sentinel.adapter.dubbo.fallback.DubboFallback;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcResult;

/**
 * @Author: yejunyu
 * @Date: 2018/9/8
 * @Email: yyyejunyu@gmail.com
 */
public class MyFallback implements DubboFallback {
    @Override
    public Result handle(Invoker<?> invoker, Invocation invocation, BlockException e) {
        return new RpcResult("aaaaaaaa");
    }
}
