package com.xitech.web.config;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*@Component
@PropertySource("classpath:redis-cluster-config.properties")*/
public class XitechAppRedisClusterConfig {

	 /*
     * spring.redis.cluster.nodes[0] = 127.0.0.1:7379
     * spring.redis.cluster.nodes[1] = 127.0.0.1:7380
     * ...
     */
    List<String> nodes;

    /**
     * Get initial collection of known cluster nodes in format {@code host:port}.
     *
     * @return
     */
    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
