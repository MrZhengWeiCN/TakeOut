package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.zhwei.comment.component.JedisClient;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@Test
	public void testJedisCluster() throws Exception {
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("127.0.0.1", 6379));
		nodes.add(new HostAndPort("127.0.0.1", 6380));
		nodes.add(new HostAndPort("127.0.0.1", 6381));
		nodes.add(new HostAndPort("127.0.0.1", 6382));
		nodes.add(new HostAndPort("127.0.0.1", 6383));
		nodes.add(new HostAndPort("127.0.0.1", 6384));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("cluster", "TestFromOnePort");
		System.out.println(jedisCluster.get("cluster"));
	}

	@Test
	public void testJedisSingleton() {
		JedisPool jedisPool = new JedisPool("127.0.0.1", 6381);
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get("cluster");
		System.out.println(result);
		jedis.close();
		jedisPool.close();
	}

	@Test
	public void testJedisClientSpring() throws Exception {
		// 创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-*.xml");
		// 从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		// jedisClient操作redis
		String string = jedisClient.get("cluster");
		System.out.println(string);
	}

}
