package edu.zhwei.search.component.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import edu.zhwei.search.component.JedisClient;

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

	@Override
	public Long zAdd(String key, int score, String member) {
		Jedis jedis = pool.getResource();
		Long zadd = jedis.zadd(key, score, member);
		jedis.close();
		return zadd;
	}

	@Override
	public Double zIncryBy(String key, int increment, String member) {
		Jedis jedis = pool.getResource();
		Double zincrby = jedis.zincrby(key, increment, member);
		jedis.close();
		return zincrby;
	}

	@Override
	public Set<String> zRevRange(String key, int start, int stop) {
		Jedis jedis = pool.getResource();
		Set<String> zrevrange = jedis.zrevrange(key, start, stop);
		jedis.close();
		return zrevrange;
	}

}
