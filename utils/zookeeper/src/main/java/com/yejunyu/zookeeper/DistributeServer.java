package com.yejunyu.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @Author: yejunyu
 * @Date: 2018/11/12
 * @Email: yyyejunyu@gmail.com
 */
public class DistributeServer {
    private String connectString = "localhost:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // 1. 连接zookeeper
        DistributeServer server = new DistributeServer();
        server.getConnect();
        // 2. 注册节点
        server.regist(args[0]);
        // 3. 业务逻辑
        server.bussiness();
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        zkClient.create("/servers/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("this host " + hostname + " is online.");
    }

    private void bussiness() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, watchedEvent -> {

        });
    }
}
