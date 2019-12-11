package com.lms.model;

public class DataInit{
    static int currentUsers = 0;
    static int currentBooks = 0;
    static int currentStaff = 0;
    public static StudentUser[] students = new StudentUser[5];
    public static StaffUser[] staff = new StaffUser[2];
    public static HardMedia[] hardBooks = new HardMedia[5];
    public static void initializeData(){
        students[0] = new StudentUser("Mihir","CE",1,"23",5,5); currentUsers++;
        staff[0] = new StaffUser("GirishSir","CE",1,15); currentStaff++;
        hardBooks[0] = new HardMedia("67","The Complete Reference","Tejas Rupani",5.5,2); currentBooks++;
        hardBooks[1] = new HardMedia("1","Digital Minimalism","Mihir Joshi",1.2,2); currentBooks++;
        System.out.println("Data Initialized.");
    }

    public static void createAccount(String name, String branch, int id, String enrollNo, int semester){
        String message = "";
        int i;
        for(i = 0; i < students.length; i++)
        {
            if(students[i] != null)
            if(students[i].id == id)
            {
                message += "Account already exists. Try different ID.";
                break;
            }
        }
        if(i == students.length)
        {
            students[currentUsers] = new StudentUser(name, branch, id, enrollNo, semester, 3);
            message += "Account Created.";
        }
        System.out.println(message);
    }
}