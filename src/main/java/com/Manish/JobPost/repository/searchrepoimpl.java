package com.Manish.JobPost.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
// import org.springframework.data.mongodb.core.mapping.Document;port org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

import com.Manish.JobPost.model.post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class searchrepoimpl implements searchrepo {

    @Autowired
    MongoClient Client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<post> findByText(String text) {

        final List<post> posts = new ArrayList<>();

        MongoDatabase database = Client.getDatabase("Manish");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("desc", "techs")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));
        result.forEach(doc -> posts.add(converter.read(post.class, doc)));
        return posts;

    }

}
