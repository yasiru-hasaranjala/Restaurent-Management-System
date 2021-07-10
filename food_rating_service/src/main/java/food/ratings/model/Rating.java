package food.ratings.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ComposidePrimaryKey.class)
public class Rating {

    @Id
    String itemID;
    @Id
    String userID;
    String rate;
    String description;

    public Rating(){

    }

    public Rating(String itemID, String userID, String rate, String description) {
        this.itemID = itemID;
        this.userID = userID;
        this.rate = rate;
        this.description = description;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
