// It uses the repository class, talks to the database and gets the list of the movies and returns to the api layer.
// Repository layer is the data access layer for the api. It gets the data from the database
package dev.bency.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
//Inside the service class we will need a reference of the repository for reference
    //This will let the framework know that we want it to instantiate the class below i.e: the MovieRepository class
    @Autowired
    //we need to initialize it or call Autowired
    private MovieRepository movieRepository;

    //this will return a list of all the movies
    public List<Movie> allMovies()
    {
        //this is in the class Mongo Repository
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
