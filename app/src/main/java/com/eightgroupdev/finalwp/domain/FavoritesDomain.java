package com.eightgroupdev.finalwp.domain;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class FavoritesDomain {
    private String title;
    private String shop;
    public int picResourceId; // Resource ID for the image
    private Double fee;
    private int countInCart;

    public FavoritesDomain(String title, String shop, int picResourceId, Double fee) {
        this.title = title;
        this.shop = shop;
        this.picResourceId = picResourceId;
        this.fee = fee;
    }

    public FavoritesDomain(String title, String shop, int picResourceId, Double fee, int countInCart) {
        this.title = title;
        this.shop = shop;
        this.picResourceId = picResourceId;
        this.fee = fee;
        this.countInCart = countInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public Drawable getPic(Context context) {
        return context.getResources().getDrawable(picResourceId);
    }

    public void setPic(int picResourceId) {
        this.picResourceId = picResourceId;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getCountInCart() {
        return countInCart;
    }

    public void setCountInCart(int countInCart) {
        this.countInCart = countInCart;
    }
}
