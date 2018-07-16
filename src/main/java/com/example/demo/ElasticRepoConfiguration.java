package com.example.demo;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticRepoConfiguration {

    @Bean
    TransportClient client() {
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("cluster.name", "docker-cluster")
                .put("xpack.security.user", "elastic:changeme")
                .build();
        try {
            return new PreBuiltXPackTransportClient(settings)
//            return new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}

