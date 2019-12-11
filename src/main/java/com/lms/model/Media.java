package com.lms.model;

public class Media{
    public String isbn, author, publication, version, title, category;
    double bookPrice;
    int pages;
    Media(String isbn, String title, String author){
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }
}