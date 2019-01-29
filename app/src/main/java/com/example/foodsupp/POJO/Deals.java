package com.example.foodsupp.POJO;

/**
 * Created by Muhammad Anas Shamsi on 11/24/18.
 */
public class Deals {

    private String deliveryTime,dealPrice,dealTitle;

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getDealTitle() {
        return dealTitle;
    }

    public void setDealTitle(String dealTitle) {
        this.dealTitle = dealTitle;
    }

    public Deals(String deliveryTime, String dealPrice, String dealTitle) {
        this.deliveryTime = deliveryTime;
        this.dealPrice = dealPrice;
        this.dealTitle = dealTitle;
    }
}
