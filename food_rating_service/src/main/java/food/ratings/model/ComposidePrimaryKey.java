package food.ratings.model;

import java.io.Serializable;

public class ComposidePrimaryKey implements Serializable {

    String itemID;
    String userID;

    public ComposidePrimaryKey(){

    }

    public ComposidePrimaryKey(String itemID, String userID) {
        this.itemID = itemID;
        this.userID = userID;
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
}
