package com.lms.model;

import java.util.Arrays;

public class StudentUser extends User{
    public String enrollNo;
    public int semester;
    public int issuedBooks[];
    StudentUser(String name, String branch, int id, String enrollNo, int semester, int balance){
        super(name, branch, id);
        this.enrollNo = enrollNo;
        this.semester = semester;
        this.balance = balance;
        issuedBooks = new int[balance];
        Arrays.fill(issuedBooks, -1);
    }
}