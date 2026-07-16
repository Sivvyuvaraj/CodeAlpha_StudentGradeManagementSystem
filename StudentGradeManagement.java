package com.Java.studentgradesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeManagement {
	static final int subjects=5;
	static List<String> Name=new ArrayList<String>();
	static List<Double[]> marksList=new ArrayList<Double[]>();
	static Scanner in=new Scanner(System.in);
	static void addstudent() {
		in.nextLine();
		System.out.println("Enter Student Name");
		Name.add(in.nextLine());
		
		 Double[] marks=new Double[subjects];
		for(int i=0;i<subjects;i++) {
			// System.out.println("DEBUG: loop iteration i=" + i); // temporary line
			    System.out.print("Enter Mark for Subject : "+ (i+1));
			    
			double temp=in.nextDouble();	

	        if (temp < 0 || temp > 100) {
	            System.out.println("Invalid Marks Input, try again");
	            // NO break here — while(true) loops again, same subject i
	        } else {
	            marks[i] = temp;
	            break; // valid mark — exit the while, go to next subject
	        }
		
	}
		marksList.add(marks);
		
		
		System.out.println("Student succesfully added");
	}
	
	public static void main(String[]args) {
		boolean run=true;
		
		while (run) {
			System.out.println("----------- MENU -----------");
	        System.out.println("1. Add Student");
	        System.out.println("2. Display Report");
	        System.out.println("3. Exit");
	        System.out.print("Enter your choice: ");
	        
	        int choose=in.nextInt();
	        switch (choose) {
	        case 1 -> addstudent();
	        case 2 -> System.out.println("You Choosed Display Report...");
	        case 3 ->{
	        	System.out.println("Exit...");
	        	run=false;
	        }
			default->
				System.out.println("Invalid Input Try With Valid options");
			}
		}
	}

}
