package com.ds.orderservice.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cusid")
    private String cusid;

    @Column(name = "itemid")
    private String itemid;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "description")
    private String description;


    @Column(name = "amount")
    private String amount;

    @Column(name = "supplied")
    private boolean supplied;

    @Column(name = "order_time")
    private String orderedTime;

    public Order() {

    }

    public Order(String cusid,String itemid,String quantity, String description,String amount, boolean supplied,Timestamp orderedTime) {
        this.cusid=cusid;
        this.itemid=itemid;
        this.quantity = quantity;
        this.description = description;
        this.amount = amount;
        this.supplied = supplied;
        this.orderedTime = orderedTime.toString();

    }

    public long getId() {
        return id;
    }

    public String getCusid() {
        return cusid;
    }
    public void setCusid(String cusid) {

        if(cusid!=null){
        this.cusid = cusid;}
    }

    public String getItemid() {

        return itemid;
    }
    public void setItemid(String itemid) {
        if(itemid!=null){
        this.itemid = itemid;}
    }


    public String getQuantity() {

        return quantity;
    }

    public void setQuantity(String quantity) {
        if(quantity!=null){
        this.quantity = quantity;}
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        if(description!=null){
        this.description = description;}

    }




    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        if(amount!=null){
        this.amount = amount;}
    }




    public boolean isSupplied() {
        return supplied;
    }

    public void setSupplied(boolean isSupplied) {
        this.supplied = isSupplied;
    }

    public String getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Timestamp orderedTime) {
        this.orderedTime = orderedTime.toString();
    }


    @Override
    public String toString() {
        return "Order [id=" + id + ",cusid= " + cusid + ",itemid= " + itemid + ",quantity=" + quantity + ", desc=" + description + ",amount=" + amount + ", supplied=" + supplied + ",order_time=" + orderedTime + "]";
    }



}
