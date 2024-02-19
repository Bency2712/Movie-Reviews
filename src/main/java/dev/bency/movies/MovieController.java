//Rest API has multiple layers and One of the layer is the movie controller, it will be getting a request from the user and returning a response
//It is using a service class and delegating  the task of fetching all the movies from the database and giving it back to the api layer. It calls the allMovie method inside the movieService and returns Http OK
package dev.bency.movies;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")

//we need reference to the movie class
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        //httpstatus.OK is 200
        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
    }

    //to search a movie by id
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId ){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}

