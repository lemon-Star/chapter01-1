package wxx.boker.chapter011.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

//@Configuration
//@ConfigurationProperties("spring.redis.cluster")
public class RedisListConfig {
    List<Integer> ports;

    String host;

    JedisPoolConfig jedisPoolConfig;

    @Bean
    RedisClusterConfiguration redisClusterConfiguration(){
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        List<RedisNode> nodes = new ArrayList<>();
        for(Integer port : ports){
            nodes.add(new RedisNode(host,port));
        }
        redisClusterConfiguration.setPassword(RedisPassword.of("123456"));
        redisClusterConfiguration.setClusterNodes(nodes);
        return redisClusterConfiguration;
    }


}
