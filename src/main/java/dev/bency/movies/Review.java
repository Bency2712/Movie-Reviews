package dev.bency.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//We haven't created this collection yet, but the application itself has that collection
@Document(collection = "reviews")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    private ObjectId id;
    private String body;

    //since ids are auto generated we cannot pass ids directly into the class
    //hence we will create custom constructor


    public Review(String body) {
        this.body = body;
    }
}
