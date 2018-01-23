package edu.zhwei.comment.component.impl;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import edu.zhwei.comment.component.JedisClient;

public class JedisClientSingle implements JedisClient {

	@Autowired
	private JedisPool pool;
	
	@Override
	public String get(String key) {
		Jedis jedis = pool.getResource();
		String result = jedis.get(key);
		jedis.close();
		return result;
	}

	@Override
	public Long hset(String key, String item, String value) {
		Jedis jedis = pool.getResource();
		Long result = jedis.hset(key, item, value);
		jedis.close();
		return result;
	}

	@Override
	public String hget(String key, String item) {
		Jedis jedis = pool.getResource();
		String result = jedis.hget(key, item);
		jedis.close();
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = pool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	@Override
	public Long decr(String key) {
		Jedis jedis = pool.getResource();
		Long result = jedis.decr(key);
		jedis.close();
		return result;
	}

	@Override
	public Long expire(String key, int second) {
		Jedis jedis = pool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = pool.getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}
	
	@Override
	public Long hdel(String key, String value) {
		Jedis jedis = pool.getResource();
		Long result = jedis.hdel(key, value);
		jedis.close();
		return result;
	}

	@Override
	public Long del(String string) {
		Jedis jedis = pool.getResource();
		Long result = jedis.del(string);
		jedis.close();
		return result;
	}

}
