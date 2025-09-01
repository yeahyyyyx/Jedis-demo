package com.test;

import org.junit.jupiter.api.BeforeEach;
import redis.clients.jedis.Jedis;
import org.junit.jupiter.api.Test; // 改为导入JUnit 5的Test注解

public class Demo1 {
    private Jedis jedis;
    @BeforeEach
    public void initRedisConnection() {
        // 1. 建立 Redis 连接
        jedis = new Jedis("192.168.195.128", 6379);
        // 2. 设置密码
        jedis.auth("123321"); // 例如：jedis.auth("123456")
        // 3.选择 Redis 数据库
        jedis.select(0);
    }
    //连接redis
    @Test
    public void TestPing() {
        String ping = jedis.ping();
        System.out.println(ping);
    }

}
