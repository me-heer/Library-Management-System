package com.lms.model;

public class StaffUser extends User{
    int experience;
    StaffUser(String name, String branch, int id, int experience){
      super(name, branch, id);
      this.experience = experience;
    }
}