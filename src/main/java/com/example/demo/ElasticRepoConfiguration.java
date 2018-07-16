package com.example.demo;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories
public class ElasticRepoConfiguration {

    //    @Bean
//    public ElasticsearchOperations elasticsearchTemplate(TransportClient client) {
//        return new ElasticsearchTemplate(client);
//    }
//
//
    @Bean
    TransportClient client() {
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)
                .build();
        try {
            return new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Bean
//    public ElasticsearchTemplate template() {
//
//        return new
//
//    ElasticsearchTemplate();
//        return null;
//    }
}
