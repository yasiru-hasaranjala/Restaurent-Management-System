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
    private long cusid;

    @Column(name = "itemid")
    private long itemid;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    @Column(name = "payment")
    private boolean payment;

    @Column(name = "supplied")
    private boolean supplied;

    @Column(name = "order_time")
    private String orderedTime;

    public Order() {

    }

    public Order(long cusid,long itemid,String title, String description,boolean payment, boolean supplied,Timestamp orderedTime) {
        this.cusid=cusid;
        this.itemid=itemid;
        this.title = title;
        this.description = description;
        this.payment = payment;
        this.supplied = supplied;
        this.orderedTime = orderedTime.toString();

    }

    public long getId() {
        return id;
    }

    public long getCusid() {
        return cusid;
    }
    public void setCusid(long cusid) {


        this.cusid = cusid;
    }

    public long getItemId() {

        return itemid;
    }
    public void setItemid(long itemid) {

        this.itemid = itemid;
    }


    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        if(description!=null){
        this.description = description;}

    }




    public boolean isPayment() {
        return payment;
    }

    public void setPeyment(boolean isPayment) {

        this.payment = isPayment;
    }




    public boolean isSupplied() {
        return supplied;
    }

    public void setSupplied(boolean isSupplied) {
        this.supplied = isSupplied;
    }




    public Timestamp getUpdateTime() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = df.format(new Date());
        Date orderedDate = df.parse(dateStr);
        return new java.sql.Timestamp(orderedDate.getTime());
    }



    public void setOrderedTime() {
        try {
            Timestamp timestamp = getUpdateTime();

        this.orderedTime = timestamp.toString();
        } catch (Exception e) {

        }
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ",cusid= " + cusid + ",itemid= " + itemid + ",title=" + title + ", desc=" + description + ",payment=" + payment + ", supplied=" + supplied + ",order_time=" + orderedTime + "]";
    }



}
