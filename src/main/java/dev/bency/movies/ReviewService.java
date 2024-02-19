package dev.bency.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    //review repository view and needs to be auto
    @Autowired
    //associate it with one of the movies
    private ReviewRepository reviewRepository;

    //template is another way of communicating with the database as a repository.
    //sometimes when it gets too complex, we can use a template
    //without using the repository we can use dynamic queries to the do the job in the database
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){

        //create a new review

        //when you call insert, it return the data you just pushed inside the db
        Review review= reviewRepository.insert(new Review(reviewBody));
        //associate it with one of the movies


        //template
        //We are using the template to perform and update call on the movie class
        //We need to update our array in the db and push the new review
        //matching: imdb id in the database matches the imdb id received from the user
        //apply: we call apply and create a new update definition which makes the change in the database. We want to update the review id in this with the value review
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)) //update definition
                .first();

                return review;
    }
}
