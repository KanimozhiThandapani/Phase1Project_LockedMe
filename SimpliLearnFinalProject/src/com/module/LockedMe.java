package com.module;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe {
	static String filesPath = "D:\\Eclipse\\Phase1";
	
	/**
	 * This Method will display all the menu options.
	 */
	public static void displayMenu() {
		System.out.println("*********************************************************");
		System.out.println("\tWelcome To LockedMe.com Secure App!");
		System.out.println("\tDeveloped By Kanimozhi Thandapani");
		System.out.println("*********************************************************");
		System.out.println("\t1. Display All Files");
		System.out.println("\t2. Add A New File");
		System.out.println("\t3. Delete A File");
		System.out.println("\t4. Search File");
		System.out.println("\t5. Exit");
		System.out.println("*********************************************************");
	}
    
	/**
	 * This Method will display all the files in a folder in an ascending order.
	 */
	public static void displayAllFiles() {
		File folder = new File(filesPath);
		String[] fileList = folder.list();
		if(fileList.length>0) 
		{
			System.out.println("Files List is below:");
			for(var fileName:fileList) {
				System.out.println(fileName);
			}
		}else {
			System.out.println("The Folder is empty");
		}	
	}
	
	/**
	 * This Method will add a new file to a folder.
	 */
	public static void addANewFile(){
		try {
			Scanner sc = new Scanner(System.in);
			String fileName;
			System.out.println("Enter The Name Of The File:");
			fileName=sc.nextLine();
			File newFile = new File(filesPath+"\\"+fileName);
			FileWriter fw= new FileWriter(newFile);
			//Line Count
			int linesCount;
			System.out.println("Enter The Number Of Lines");
			linesCount=Integer.parseInt(sc.nextLine());
			//Entering the Lines
			for(int i=1;i<=linesCount;i++) {
				System.out.println("Enter File Line "+i+":");
				fw.write(sc.nextLine());
			  }
			 System.out.println("File has been created successfully!!!");
			 fw.close();
		   }  
		   catch(Exception e) {
			System.out.println(e.getMessage());
		   }
	}
	
	/**
	 * This utility Method will check whether a file exists in a folder or not.
	 */
	public static boolean checkFileExists(String fileName) {
		ArrayList<String> arrayList = new ArrayList<String> ();
		File folderPath = new File(filesPath);
		File[] fileList = folderPath.listFiles();
		if(fileList.length>0) {
			for(var files:fileList) {
				arrayList.add(files.getName());
			}
		}
		return arrayList.contains(fileName);
	
	}
	
	/**
	 * This Method will delete a file in a folder.
	 */
	public static void deleteAFile() {
		try 
		{
			Scanner sc = new Scanner(System.in);
			String fileName;
			System.out.println("Enter The Name Of The File For Deletion:");
			fileName=sc.nextLine();
			File file = new File(filesPath+"\\"+fileName);
			if(checkFileExists(fileName)) 
			{
				file.delete();
				System.out.println("The File has been deleted successfully!!");
			}
			else 
			{
				System.out.println("File doesn't exist");
			}
		}
		catch(Exception e)
		{
			System.out.println("Unable to delete file.Kindly contact the Admin");
		}
		
	}

	/**
	 * This Method will search for a file in a folder.
	 */
	public static void searchFiles() {
		try
		{
			Scanner sc = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name to be searched:");
			fileName=sc.nextLine();
			if(checkFileExists(fileName)) 
			{
				System.out.println("File is available.");
			}else 
			{
				System.out.println("File is not available.");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}


}
