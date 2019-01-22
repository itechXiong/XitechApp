package com.xitech.web.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@PropertySource("classpath:redis-cluster-config.properties")
public class XitechAppConfig {

	@Autowired
	Environment env;
	
	/*@Autowired 
	XitechAppRedisClusterConfig clusterProperties;*/

	@Bean
	public RedisConnectionFactory lettuceConnFactory() {
		List<String> nodes = Arrays.asList(env.getProperty("spring.redis.cluster.nodes").split(","));
        return new LettuceConnectionFactory(new RedisClusterConfiguration(nodes));
    }
	
}
