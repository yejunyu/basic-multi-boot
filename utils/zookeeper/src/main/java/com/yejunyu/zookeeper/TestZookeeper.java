package com.yejunyu.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author: yejunyu
 * @Date: 2018/11/12
 * @Email: yyyejunyu@gmail.com
 */
public class TestZookeeper {
    private String connectString = "localhost:2181";

    private int sessionTimeout = 2000;

    private ZooKeeper zkClient;

    /**
     * 2888,leader和follower通信的端口
     * 3888,follower选举用的端口号
     */
//    private String connectString = "host1:2181,host2:2181,host3:2181";
    @Before
    public void init() {
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    try {
                        watch();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1. 创建节点
     */
    @Test
    public void createNode() {
        try {
            String path = zkClient.create("/path", "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(path);
            Thread.sleep(10000);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2. 获取子节点
     */
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        // true代表watch
        watch();
        Thread.sleep(100000);
    }

    private void watch() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }
    }

    /**
     * 3. 判断节点是否存在
     */
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/path", false);
        System.out.println(stat == null ? "not exist" : stat);
    }

}
