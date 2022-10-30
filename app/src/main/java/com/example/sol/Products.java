package com.example.sol;

public class Products {
    private int image;
    private String name;

    public Products(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }
}