package com.lms.view;

import com.lms.model.*;
import java.util.Scanner;
import com.lms.controller.*;
public class LibView{
	public static final int MAX_ALLOWED_BOOKS = 5;
	public static final int MAX_BOOK_QUANTITY = 2;
	private static void mainActivity(){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("Library Management System");
			System.out.println("1. Check Balance");
			System.out.println("2. Issue Book");
			System.out.println("3. Return Book");
			System.out.println("4. Search books");
			System.out.println("5. Create User Account");
			System.out.println("6. Display User Details");
			System.out.println("7. Exit");
			int choice = input.nextInt();
			Scanner userIDInput = new Scanner(System.in);
			Scanner bookIDInput = new Scanner(System.in);
			switch(choice)
			{
				case 1 :
						System.out.println("Enter user ID:");
						int userID = userIDInput.nextInt();
						int balance = Transaction.checkBalance(userID); 
						if(balance == -1)
							System.out.println("Please enter a valid userID.");	
						else
							System.out.println("User Balance: " + balance);
						break;
				case 2 : 
					System.out.println("Enter user ID:");
					userID = userIDInput.nextInt();
					System.out.println("Enter book ID:"); 
					int bookID = bookIDInput.nextInt();
					System.out.println(Transaction.issueBook(userID,bookID));
					break;
				case 3 : 
					System.out.println("Enter user ID:");
					userID = userIDInput.nextInt();
					System.out.println("Enter book ID:"); 
					bookID = bookIDInput.nextInt();
					System.out.println(Transaction.returnBook(userID,bookID));
					break;
				case 4 :
					System.out.println("Enter book ID:"); 
					bookID = bookIDInput.nextInt();
			 		Transaction.searchBook(bookID); break;
				case 5 : Transaction.createAccount(); break;
				case 6 : Transaction.displayUserDetails();  break;
				case 7 : input.close();
				System.exit(0); break;
				default : System.out.println("Invalid Choice."); break;
			}
			userIDInput.close();
			bookIDInput.close();
		}
		
	}

	public static void main(String[] args){
		DataInit.initializeData();
		mainActivity();
	}
}