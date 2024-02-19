package dev.bency.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    //anything we get as a request body, we would convert it to a map of the key string and value string
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        //HTTPStatus.CREATED=status 201
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }

}
