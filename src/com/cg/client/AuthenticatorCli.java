package com.cg.client;

import java.util.Scanner;

import com.cg.service.AuthenticatorService;
import com.cg.service.AuthenticatorServiceImpl;


public class AuthenticatorCli {
	
	private static Scanner console;
	
	static {
		console = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		int option = 0;
		
		while(true) {
			System.out.println("Enter Option");
			System.out.println("1 - signup 2- login 3- exit");
			option = console.nextInt();
			switch(option){
			case 1: signup(); break;
			case 2: login(); break;
			case 4: System.exit(0);
			default: System.out.println("Please enter correct option");
		}
	}
}

	private static void login() {
		AuthenticatorService service = new AuthenticatorServiceImpl();
		String password;
		int employeeId;
		
		System.out.println("Enter Employee ID");
		employeeId = console.nextInt();
		System.out.println("Enter Password");
		password = console.next();
		
		System.out.println(service.authenticateUser(employeeId, password));
		
	}

	private static void signup() {
		AuthenticatorService service = new AuthenticatorServiceImpl();
		
		System.out.println("Enter Employee ID");
		int employeeId = console.nextInt();
		
		System.out.println("Enter Name");
		String name = console.next();
		
		System.out.println("Enter Password");
		String password = console.next();
		
		System.out.println("Enter Role");
		String role = console.next();
		
		System.out.println(service.addUser(employeeId, name, password, role));
	}
}
