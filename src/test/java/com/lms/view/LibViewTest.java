package com.lms.view;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import com.lms.view.LibView;


public class LibViewTest{
    @Test
    public void addTest(){
        int a = 5, b = 6;
        assertEquals(a+b, LibView.add(a, b));
    }
}