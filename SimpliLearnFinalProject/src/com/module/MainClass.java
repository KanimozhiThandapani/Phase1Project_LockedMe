package com.module;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int choice;
		do 
		{
			LockedMe.displayMenu();
			System.out.println("Enter Your Choice:");
			choice=Integer.parseInt(sc.nextLine());
			switch(choice) 
			{
			   case 1:LockedMe.displayAllFiles();
			          break;
			   case 2:LockedMe.addANewFile(); 
			          break;
			   case 3:LockedMe.deleteAFile();
		              break;
		       case 4:LockedMe.searchFiles(); 
		              break;
		       case 5:System.exit(0);
		              break;//no need for this
		       default:System.out.println("Invalid Option!!");
		              break;      
			}
		 }
			while(choice>0);
			sc.next();
			sc.close();
	}
}
