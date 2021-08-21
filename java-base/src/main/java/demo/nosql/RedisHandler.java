package demo.nosql;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class RedisHandler {

	public static void main(String[] args) {

		// 建议连接池
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		// 从连接池获得某闲置资源
		try (Jedis resource = pool.getResource()) {
			//
			resource.set("foo", "bar");
			String foobar = resource.get("foo");
			resource.zadd("sose", 0, "car");
			resource.zadd("sose", 0, "bike");
			Set<String> sose = resource.zrange("sose", 0, -1);

			// 事务
			resource.watch("12", "bb", "aa"); //
			Transaction trns = resource.multi();
			trns.set("key1", "Jack");
			trns.set("key2", "Rose");
			trns.exec();
			Response<String> result1 = trns.get("fool");
			result1.

					t.zadd("foo", 1, "barowitch");
			t.zadd("foo", 0, "barinsky");
			t.zadd("foo", 0, "barikoviev");
			Response<Set<String>> sose = t.zrange("foo", 0, -1); // get the entire sortedset
			t.exec(); // dont forget it

			String foolbar = result1.get(); // use Response.get() to retrieve things from a Response
			int soseSize = sose.get().size(); // on sose.get() you can directly call Set methods!

			// List<Object> allResults = t.exec(); // you could still get all results at
			// once, as before
			pool.returnResource(resource); // 归还资源至连接池
		}
		pool.close();
	}

	/*
	 * public void setCluster() { Set<HostAndPort> jedisClusterNodes = new
	 * HashSet<HostAndPort>(); //Jedis Cluster will attempt to discover cluster
	 * nodes automatically jedisClusterNodes.add(new HostAndPort("127.0.0.1",
	 * 7379)); JedisCluster jc = new JedisCluster(jedisClusterNodes); jc.set("foo",
	 * "bar"); String value = jc.get("foo");
	 * 
	 * 
	 * jedis.slaveof("localhost", 6379); // if the master is on the same PC which
	 * runs your code jedis.slaveof("192.168.1.35", 6379);
	 * 
	 * 
	 * Pipeline p = jedis.pipelined(); p.set("fool", "bar"); p.zadd("foo", 1,
	 * "barowitch"); p.zadd("foo", 0, "barinsky"); p.zadd("foo", 0, "barikoviev");
	 * Response<String> pipeString = p.get("fool"); Response<Set<String>> sose =
	 * p.zrange("foo", 0, -1); p.sync();
	 * 
	 * int soseSize = sose.get().size(); Set<String> setBack = sose.get(); }
	 */

}
