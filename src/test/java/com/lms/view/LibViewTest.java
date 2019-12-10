package com.lms.view;

import org.junit.Test;
import com.lms.view.LibView;

import static org.junit.Assert.*;

public class LibViewTest{
    @Test
    public void addTest(){
        int a = 5, b = 5;
        assertEquals(a + b , LibView.add(a, b));
    }
}

