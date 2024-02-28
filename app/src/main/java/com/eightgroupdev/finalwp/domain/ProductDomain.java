package com.eightgroupdev.finalwp.domain;

public class ProductDomain {
    private String title;
    private String shop;
    private String pic;
    private Double fee;
    private int countInCart;

    public ProductDomain(String title, String shop, String pic, Double fee) {
        this.title = title;
        this.shop = shop;
        this.pic = pic;
        this.fee = fee;
    }

    public ProductDomain(String title, String shop, String pic, Double fee, int countInCart) {
        this.title = title;
        this.shop = shop;
        this.pic = pic;
        this.fee = fee;
        this.countInCart = countInCart;
    }

    // Getter and setter methods for the properties
}