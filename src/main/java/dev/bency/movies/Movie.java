package dev.bency.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

//This class let the framework know this class represents a document
@Document(collection = "movies")

//This comes from the lombok project and takes care of all the getter setter and to string methods
@Data

//Annotation that takes all the private fields as arguments
@AllArgsConstructor

// Constructor that takes no arguments
@NoArgsConstructor
public class Movie {

    //this will let Object id be treated as a unique id inside the database
    @Id
    private Object id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    //This will be an embedded relationship. All the reviews added to the movie will be added to the list

    //this will cause the db to store only the ids of the reviews and the reviews will be in a seperate collection
    @DocumentReference
    private List<Review> reviewIds;
}
