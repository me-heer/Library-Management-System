package com.lms.controller;

import java.util.Scanner;
import com.lms.view.LibView;
import com.lms.model.DataInit;

public class Transaction{

    public static void displayUserDetails(){
        String message = "";
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter User ID: ");
        int id = userInput.nextInt();
        userInput.close();
        boolean userFound = false;
        int i;
        for(i = 0; i < DataInit.students.length; i++)
        {
            if(DataInit.students[i] != null)
            if(id == DataInit.students[i].id)
            {
                userFound = true;
                message += "User Found.";
                break;
            }
        }
        if(i == DataInit.students.length)
            message += "Invalid user ID. Please try again.";
        System.out.println(message);
        if(userFound)
        {
            System.out.println("ID: " + DataInit.students[i].id);
            System.out.println("Name: " + DataInit.students[i].name);
            System.out.println("Branch: " + DataInit.students[i].branch);
            System.out.println("Enrollment No.: " + DataInit.students[i].enrollNo);
            System.out.println("Semester: " + DataInit.students[i].semester);
            System.out.println("Balance: " + DataInit.students[i].balance);
            System.out.println("Issued Books: ");
            if (DataInit.students[i].balance < com.lms.view.LibView.MAX_ALLOWED_BOOKS) {

                for (int k = 0; k < DataInit.students[i].issuedBooks.length; k++) {
                    if (DataInit.students[i].issuedBooks[k] != -1) {
                        int j = DataInit.students[i].issuedBooks[k];
                        System.out.println("Title: " + DataInit.hardBooks[j].title);
                        System.out.println("ISBN: " + DataInit.hardBooks[j].isbn);
                        System.out.println("Author: " + DataInit.hardBooks[j].author);
                        System.out.println("Available Quantity of Paperback: " + DataInit.hardBooks[j].quantity);
                        System.out.println("Weight: " + DataInit.hardBooks[j].weight);
                    }

                }
            }


        }
    }

    public static void createAccount(){
        //name branch id enroll semester
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = userInput.nextLine();
        System.out.println("Enter your branch: ");
        String branch = userInput.nextLine();
        System.out.println("Enter your id: ");
        int id = Integer.parseInt(userInput.nextLine());
        System.out.println("Enter your enrollment no: ");
        String enrollNo = userInput.nextLine();
        System.out.println("Enter your semester: ");
        int semester = Integer.parseInt(userInput.nextLine());
        userInput.close();
        DataInit.createAccount(name, branch, id, enrollNo, semester);
    }

    public static String issueBook(int userID,int bookID){
        int i,j;
        boolean userFound = false;
        String message = "";
        for(i = 0; i < DataInit.students.length; i++)
        {
            if(DataInit.students[i] != null)
            if(DataInit.students[i].id == userID)
            {
                userFound = true;
                break;
            }
        }
        if (i == DataInit.students.length)
        {
            message += "User not found, please try again.\n";
        }
        else if(userFound)
        {
            message += "User found.\n";
        }

        boolean bookFound = false;
        for(j = 0; j < DataInit.hardBooks.length; j++)
        {
            if(DataInit.hardBooks[j] != null)
            if( Integer.parseInt(DataInit.hardBooks[j].isbn) == bookID)
            {
                bookFound = true;
                break;
            }
        }
        if (j == DataInit.hardBooks.length)
        {
            message += "Book not found, please try again.\n";
        }
        else if(bookFound)
        {
            message += "Book found.\n";
        }
        if(bookFound && userFound)
        {
            if(DataInit.students[i].balance > 0)
            {
                if(DataInit.hardBooks[j].quantity > 0)
                {
                    DataInit.students[i].issuedBooks[LibView.MAX_ALLOWED_BOOKS - DataInit.students[i].balance] = j;
                    DataInit.students[i].balance--;
                    DataInit.hardBooks[j].currentUsers[LibView.MAX_BOOK_QUANTITY - DataInit.hardBooks[j].quantity] = i;
                    DataInit.hardBooks[j].quantity--;
                    message += "Successfully issued the book.\n";
                }
                else
                    message += "Sorry, the book is not available at the time.\n";
            }
            else
                message += "Insufficient User Balance.\n";

            message += "User balance: " + DataInit.students[i].balance;
            message += "Book quantity: " + DataInit.hardBooks[j].quantity;
        }
        
        return message;
    }


    public static String returnBook(int userID,int bookID){
        int i,j;
        boolean userFound = false;
        String message = "";
        for(i = 0; i < DataInit.students.length; i++)
        {
            if(DataInit.students[i] != null)
            if(DataInit.students[i].id == userID)
            {
                userFound = true;
                break;
            }
        }
        if (i == DataInit.students.length)
        {
            message += "User not found, please try again.\n";
        }
        else if(userFound)
        {
            message += "User found. \n";
        }

        boolean bookFound = false;
        for(j = 0; j < DataInit.hardBooks.length; j++)
        {
            if(DataInit.hardBooks[j] != null)
            if( Integer.parseInt(DataInit.hardBooks[j].isbn) == bookID)
            {
                bookFound = true;
                break;
            }
        }
        if (j == DataInit.hardBooks.length)
        {
            message += "Book not found, please try again.\n";
        }
        else if(bookFound)
        {
            message += "Book found.\n";
        }
        if(bookFound && userFound)
        {
            DataInit.students[i].balance++;
            DataInit.hardBooks[j].quantity++;
            for(int m = 0; m < DataInit.students[i].issuedBooks.length; m++)
            {
                //find the book
                if(DataInit.students[i].issuedBooks[m] != -1)
                if(bookID == Integer.parseInt(DataInit.hardBooks[ DataInit.students[i].issuedBooks[m] ].isbn))
                {
                    for(int n = 0; n < DataInit.hardBooks[ DataInit.students[i].issuedBooks[m] ].currentUsers.length; n++)
                        if(DataInit.hardBooks[ DataInit.students[i].issuedBooks[m] ].currentUsers[n] != -1)
                        if(DataInit.hardBooks[ DataInit.students[i].issuedBooks[m] ].currentUsers[n] == i)
                        {
                            DataInit.hardBooks[ DataInit.students[i].issuedBooks[m] ].currentUsers[n] = -1;
                            break;
                        }
                    DataInit.students[i].issuedBooks[m] = -1;
                }
            }

            message += "Successfully returned the book.\n";
            message += "User balance: " + DataInit.students[i].balance;
            message += "Book quantity: " + DataInit.hardBooks[j].quantity;
        }
        
        return message;
    }

    public static void searchBook(String searchString)
    {
        int j;
        String message = "";
        boolean bookFound = false;
        for(j = 0; j < DataInit.hardBooks.length; j++)
        {
            if(DataInit.hardBooks[j] != null)
                if( (DataInit.hardBooks[j].title.contains(searchString)) )
                {
                    bookFound = true;
                    break;
                }
        }
        if (j == DataInit.hardBooks.length)
        {
            message += "Book not found, please try again.\n";
        }
        else if(bookFound)
        {
            System.out.println("Book details: ");
            System.out.println("Title: " + DataInit.hardBooks[j].title);
            System.out.println("ISBN: " + DataInit.hardBooks[j].isbn);
            System.out.println("Author: " + DataInit.hardBooks[j].author);
            System.out.println("Available Quantity of Paperback: " + DataInit.hardBooks[j].quantity);
            System.out.println("Weight: " + DataInit.hardBooks[j].weight);
            System.out.println("Current Users:");
            if(DataInit.hardBooks[j].quantity < LibView.MAX_BOOK_QUANTITY)
            {
                for(int k = 0; k < DataInit.hardBooks[j].currentUsers.length; k++)
                {
                    if(DataInit.hardBooks[j].currentUsers[k] != -1)
                    {
                        int i = DataInit.hardBooks[j].currentUsers[k];
                        System.out.println("ID: " + DataInit.students[i].id);
                        System.out.println("Name: " + DataInit.students[i].name);
                        System.out.println("Branch: " + DataInit.students[i].branch);
                        System.out.println("Enrollment No.: " + DataInit.students[i].enrollNo);
                        System.out.println("Semester: " + DataInit.students[i].semester);
                        System.out.println("Balance: " + DataInit.students[i].balance);

                    }

                }
            }
        }
        System.out.println(message);
    }

    public static void searchBook(int bookID){
        int j;
        String message = "";
        boolean bookFound = false;
        for(j = 0; j < DataInit.hardBooks.length; j++)
        {
            if(DataInit.hardBooks[j] != null)
            if( Integer.parseInt(DataInit.hardBooks[j].isbn) == bookID)
            {
                bookFound = true;
                break;
            }
        }
        if (j == DataInit.hardBooks.length)
        {
            message += "Book not found, please try again.\n";
        }
        else if(bookFound)
        {
            System.out.println("Book details: ");
            System.out.println("Title: " + DataInit.hardBooks[j].title);
            System.out.println("ISBN: " + DataInit.hardBooks[j].isbn);
            System.out.println("Author: " + DataInit.hardBooks[j].author);
            System.out.println("Available Quantity of Paperback: " + DataInit.hardBooks[j].quantity);
            System.out.println("Weight: " + DataInit.hardBooks[j].weight);
            System.out.println("Current Users:");
            if(DataInit.hardBooks[j].quantity < LibView.MAX_BOOK_QUANTITY)
            {
                for(int k = 0; k < DataInit.hardBooks[j].currentUsers.length; k++)
                {
                    if(DataInit.hardBooks[j].currentUsers[k] != -1)
                    {
                        int i = DataInit.hardBooks[j].currentUsers[k];
                        System.out.println("ID: " + DataInit.students[i].id);
                        System.out.println("Name: " + DataInit.students[i].name);
                        System.out.println("Branch: " + DataInit.students[i].branch);
                        System.out.println("Enrollment No.: " + DataInit.students[i].enrollNo);
                        System.out.println("Semester: " + DataInit.students[i].semester);
                        System.out.println("Balance: " + DataInit.students[i].balance);

                    }

                }
            }

        }
        System.out.println(message);
    }

    public static int checkBalance(int userID)
    {
        int i;
        for(i = 0; i < DataInit.students.length; i++)
        {
            if(DataInit.students[i] != null)
            if(DataInit.students[i].id == userID)
            {
                break;
            }
        }
        if (i == DataInit.students.length)
        {
            System.out.println("User not found, please try again.");
            return -1;
        }
        else
        {
            System.out.println("User found.");
            return DataInit.students[i].balance;
        }
    }
}