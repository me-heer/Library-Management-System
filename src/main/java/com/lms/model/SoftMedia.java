package com.lms.model;

import java.util.Arrays;

public class SoftMedia extends Media {
    double fileSize;
    String fileFormat;
    public int quantity;
    public int currentUsers[];
    SoftMedia(String isbn, String title, String author,double fileSize, int quantity,String fileFormat){
        super(isbn,title,author);
        this.quantity = quantity;
        this.fileFormat = fileFormat;
        currentUsers = new int[quantity];
        Arrays.fill(currentUsers, -1);
    }
}