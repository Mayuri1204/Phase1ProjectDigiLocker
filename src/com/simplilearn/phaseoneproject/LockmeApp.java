package com.simplilearn.phaseoneproject;


import java.io.*;

import java.util.*;




public class LockmeApp {
	
	private static Scanner keyboard;
	private static Scanner Input;
	private static Scanner lockerInput;
	
	private static PrintWriter Output;
	private static PrintWriter lockerOutput;
	
	private static Users users;
	private static UserCredentials usercredentials ;
	
	
	


	public static void signInOptions() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("1. Registration");
		System.out.println("2. Login");
		int option = keyboard.nextInt();
		
		switch(option)
		{
		case 1 : 
			registerUser();
			break;
			
		case 2 :
			loginUser();
			break;
			
		default :
			System.out.println("Please select from above options");
			break;
		
		}
		keyboard.close();
		Input.close();
	
	}
	
	
	
	public static void lockerOptions(String inpusername) {
	System.out.println("1. show saved credentials");
	System.out.println("2. Store new credentials");
	int options = keyboard.nextInt();
	switch(options) {
	case 1 :
		fetchCredentials(inpusername);
		break;
		
	case 2 :
		storeCredentials(inpusername);
		break;
		
	default :
		System.out.println("Please select from above options");
		break;
	}
	lockerInput.close();
	}
	
	public static void registerUser() {
		System.out.println(" --------------------------------------- ");
		System.out.println("          Welcome to LockMe App          ");
		System.out.println(" --------------------------------------- ");
		
		keyboard = new Scanner(System.in);

		System.out.println("Enter Username :");
		Scanner keyboard = new Scanner (System.in);
		String user = keyboard.nextLine();
			
		System.out.println("Enter Password :");
		String password = keyboard.nextLine();

		
		Output.println(users.getUsername());
		Output.println(users.getPassword());
		
		System.out.println("User registration successfull");
		Output.close();
		keyboard.close();
	}
	
	public static void loginUser() {
		System.out.println("******************************************");
		System.out.println("------------------------------------------");
		System.out.println("         Welcome to Login page            ");
		System.out.println("------------------------------------------");
		System.out.println("******************************************");
		
		System.out.println("Enter Username ");
		String inpusername = keyboard.next();
		boolean found = false;
		
		
		while(Input.hasNext() && !found) {
			if(Input.next().equals(inpusername)) {
				System.out.println("Enter password");
				String inpPassword = keyboard.next();
				
				if(Input.next().equals(inpPassword)) {
					System.out.println("Login successful");
					found = true;
					lockerOptions(inpusername);
					break;
				}
			}
			
				}
		
		if(!found) {
			System.out.println("User details not valid");
			}
		
		}
		
	
	public static void welcomeScreen() {
		System.out.println("::::::::::::::::::::::::::::::::::::::::");
		System.out.println("       **************************       ");
		System.out.println("         Welcome to LockMe App          ");
		System.out.println("      Your personal digital locker       ");
		System.out.println("       **************************       ");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::");
		
	}
	
	public static void storeCredentials(String loggedInUser) {
		System.out.println("********************************************");
		System.out.println("      ---- Store your credentials ----      ");
		System.out.println("********************************************");
		
		
		usercredentials.setLoggedInUser(loggedInUser);
		
		
		System.out.println("Enter Site name");
		String siteName = keyboard.next();
		usercredentials.setSiteName(siteName);
		
		System.out.println("Enter Username");
		String Username = keyboard.next();
		usercredentials.setusername(Username);
		
		System.out.println("Enter Password");
		String password = keyboard.next();
		usercredentials.setPassword(password);
		
		
		lockerOutput.println(usercredentials.getLoggedInUser());
		lockerOutput.println(usercredentials.getSiteName());
		lockerOutput.println(usercredentials.getuserName());
		lockerOutput.println(usercredentials.getPassword());
		
		System.out.println("Credentials saved");
		lockerOutput.close();
	}
	
	
	public static void fetchCredentials(String inpusername) {
		System.out.println("Credentials : ");
		System.out.println(inpusername);
		
		while(lockerInput.hasNext()) {
			System.out.println(lockerInput.hasNext());
			
			if(lockerInput.next().equals(inpusername)) {
				System.out.println("Site name:"   +lockerInput.next());
				System.out.println("Username:"  +lockerInput.next());
				System.out.println("Password:"  +lockerInput.next());
			}
		}
	}
	
	



	private static void initApp() {

		File creds = new File("credentials.txt");
		File mains = new File("Main-file.txt");
		
		try {
			Input = new Scanner(creds);
			lockerInput = new Scanner(mains);
			
			keyboard = new Scanner(System.in);
			
			Output = new PrintWriter(new FileWriter(creds,true));
			boolean t = true;
			lockerOutput = new PrintWriter(new FileWriter(mains,t));
			
			users = new Users();
			
			
		}
		catch (IOException e) {
			System.out.println("File not available");
		}
		
	}
	
	
	
	public static void main (String[] args) {
	   
	    welcomeScreen();
	    signInOptions();
	    initApp();
	    registerUser();
	    loginUser();
	    String String = " ";
		fetchCredentials(String);
	    lockerOptions(String);
	    storeCredentials(String);
	    
	}	
}
