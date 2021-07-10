package food.ratings.dao;

import food.ratings.model.ComposidePrimaryKey;
import food.ratings.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository <Rating, ComposidePrimaryKey> {

    @Query("select r from Rating r where r.itemID =?1")
    List<Rating> findAll(String itemID);

    @Query("select r from Rating r where r.itemID =?1 and r.userID=?2")
    List<Rating> findSingle(String itemID, String userID);

    @Modifying
    @Query("update Rating r set r.rate=?1 where r.itemID=?2 and r.userID=?3")
    void update(String rt,String iID,String uID);






}
