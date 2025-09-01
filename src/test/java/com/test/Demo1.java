package com.test;

import com.yyx.JedisConnectionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import redis.clients.jedis.Jedis;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class Demo1 {
    private Jedis jedis;
    @BeforeEach
    public void initRedisConnection() {
        // 1. 建立 Redis 连接
//        jedis = new Jedis("192.168.195.128", 6379);
        jedis = JedisConnectionFactory.getJedis();
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
    @Test
    public void TestString() {
        String result = jedis.set("name", "yyx");
        System.out.println("result = " + result);
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }
    @Test
    public void TestHash() {
        jedis.hset("user:1", "name", "Jack");
        jedis.hset("user:1", "age", "18");
        Map<String, String> map =jedis.hgetAll("user:1");
        System.out.println("map = " + map);
    }
    @AfterEach
    public void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
