package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticRepoTest {

    @Autowired
    TransportClient client;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void loads(){
        assertNotNull(client);
    }

    @Test
    public void indexesData() throws JsonProcessingException {
        SomeModel someModel = new SomeModel("someSector", "someWord");
        IndexResponse indexResponse = client.prepareIndex("my_index", "my_type")
                .setSource(objectMapper.writeValueAsString(someModel), XContentType.JSON).get();

        System.out.println(indexResponse);
    }
}