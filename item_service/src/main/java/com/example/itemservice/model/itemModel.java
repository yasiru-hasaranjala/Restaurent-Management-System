package com.example.itemservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class itemModel {

    @Id
    String itemID;
    String itemName;
    String imgUrl;
    String description;
    String price;

    public itemModel(){

    }

    public itemModel(String itemID, String itemName, String imgUrl, String description, String price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.imgUrl = imgUrl;
        this.description = description;
        this.price = price;
    }


    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}

