package com.example.demo;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//@Document(indexName = "someIndex", type = "someType")
public class SomeModel {

//    @Id
    private String id;
}
