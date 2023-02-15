package top.damoncai.distributelok.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

/**
 * redis分布式锁
 */
public class RedisDistributeLock {

    private static String LOCK_NAME = "rlock";

    private static JedisPool pool = new JedisPool("localhost", 6379);

    static int num = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            Jedis jedis = pool.getResource();
            while (true) {
                // 获取锁
                lock(jedis);
                num ++;
                System.out.println("num: " + num);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                unlock(jedis);
            }
        }).start();
        new Thread(() -> {
            Jedis jedis = pool.getResource();
            while (true) {
                // 获取锁
                lock(jedis);
                num ++;
                System.out.println("num: " + num);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                unlock(jedis);
            }
        }).start();

    }

    /**
     * 上锁
     */
    public static Jedis lock(Jedis jedis) {
        SetParams params = new SetParams();
        params.nx();
        params.ex(10);
        String res = jedis.set(LOCK_NAME, "name", params);
        return jedis;
    }

    /**
     * 释放锁
     * @param jedis
     */
    public static void unlock(Jedis jedis) {
        jedis.del(LOCK_NAME);
    }
}
