package dev.bency.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
//Instead of searching it with object id we should be able to search it using its IMDB id. To search with IMDB id it doesn't come inbuilt, so we have to create that method ourselves
//automatic queries lets you for queries dynamically using properties
    Optional<Movie> findMovieByImdbId(String imdbId);

}
