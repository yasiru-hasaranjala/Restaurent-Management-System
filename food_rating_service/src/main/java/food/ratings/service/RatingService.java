package food.ratings.service;

import food.ratings.dao.RatingRepository;
import food.ratings.model.ComposidePrimaryKey;
import food.ratings.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public void saveRating( Rating rate ){

        ratingRepository.save(rate);
    }

    public List<Rating> getAllRatings(String itemid) {
        return ratingRepository.findAll(itemid);
    }

    public List<Rating> getSingleRating(String itemid, String userid) {
        return ratingRepository.findSingle(itemid, userid);
    }

    public void updateRating(Rating rate, String itemid, String userid) {
        String a=rate.getRate();
        String b=rate.getDescription();
        ratingRepository.update(a,itemid,userid);
    }


    public void deleteRating(String itemid, String userid) {
        ComposidePrimaryKey deleteID=new ComposidePrimaryKey();
        deleteID.setItemID(itemid);
        deleteID.setUserID(userid);
        ratingRepository.deleteById(deleteID);
    }


}
