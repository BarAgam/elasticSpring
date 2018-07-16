package com.example.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRepo extends ElasticsearchRepository<SomeModel,String> {
}
