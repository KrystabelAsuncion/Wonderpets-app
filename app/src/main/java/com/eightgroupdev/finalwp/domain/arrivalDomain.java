package com.eightgroupdev.finalwp.domain;

public class arrivalDomain {
    private String title;
    private String shop;
    private String pic;
    private Double fee;
    private int countInCart;

    public arrivalDomain(String title, String shop, String pic, Double fee) {
        this.title = title;
        this.shop = shop;
        this.pic = pic;
        this.fee = fee;
    }

    public arrivalDomain(String title, String shop, String pic, Double fee, int countInCart) {
        this.title = title;
        this.shop = shop;
        this.pic = pic;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
