package food.ratings.controller;

import food.ratings.model.Rating;
import food.ratings.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingservice;

    @PostMapping("/saverating")
    public ResponseEntity saveRating(@RequestBody Rating rate){
        ratingservice.saveRating(rate);
        return new ResponseEntity(rate, HttpStatus.OK);
    }


    @GetMapping("getallratings/{itemid}")
    public ResponseEntity<List<Rating>> getAllRatings(@PathVariable String itemid){
        return new ResponseEntity(ratingservice.getAllRatings(itemid), HttpStatus.OK);
    }

    @GetMapping("getsinglerate/{itemid}/{userid}")
    public ResponseEntity<List<Rating>> getSingleRating(@PathVariable String itemid,@PathVariable String userid){
        return new ResponseEntity(ratingservice.getSingleRating(itemid, userid), HttpStatus.OK);
    }

    @PutMapping("updaterating/{itemid}/{userid}")
    public ResponseEntity updateRating(@RequestBody Rating rate,@PathVariable String itemid,@PathVariable String userid){
        ratingservice.updateRating(rate,itemid,userid);
        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping("delete/{itemid}/{userid}")
    public ResponseEntity deleteRating(@PathVariable String itemid,@PathVariable String userid){
        ratingservice.deleteRating(itemid,userid);
        return new ResponseEntity(HttpStatus.OK);
    }


}
