package com.yyx;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static{
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(10); // 最大连接数
        poolConfig.setMaxIdle(5); // 最大空闲连接数
        poolConfig.setMinIdle(2); // 最小空闲连接数
        poolConfig.setMaxWaitMillis(1000); // 获取连接时的最大等待毫秒数
        jedisPool = new JedisPool(poolConfig,
                "192.168.195.128", 6379, 1000, "123321");
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
