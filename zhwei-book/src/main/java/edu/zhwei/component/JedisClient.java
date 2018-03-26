package edu.zhwei.component;

import java.util.Set;

public interface JedisClient {

	public String set(String key,String value);
	public String get(String key);
	public Long hset(String key, String item, String value);
	public String hget(String key, String item);
	public Long incr(String key);
	public Long decr(String key);
	public Long expire(String key, int second);
	public Long hdel(String key, String value);
	public Long del(String string);
	public Long zAdd(String key,int score,String member);
	public Double zIncryBy(String key,int increment,String member);
	public Set<String> zRevRange(String key,int start,int stop);//返回从大到小的[start,stop]的数据
}
