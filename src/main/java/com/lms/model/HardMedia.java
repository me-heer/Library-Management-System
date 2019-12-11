package com.lms.model;

import java.util.Arrays;

public class HardMedia extends Media{
    public double weight;
    public int quantity;
    public int currentUsers[];
    HardMedia(String isbn, String title, String author,double weight, int quantity){
        super(isbn,title,author);
        this.weight = weight;
        this.quantity = quantity;
        currentUsers = new int[quantity];
        Arrays.fill(currentUsers, -1);
    }
}