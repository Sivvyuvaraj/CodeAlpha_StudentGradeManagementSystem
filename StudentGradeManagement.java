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
			   while(true) {
			 System.out.print("Enter Mark for Subject "+(i+1)+ ":");  
			double temp=in.nextDouble(); 
			if (temp>=0 && temp<=100) {
	               marks[i]=temp;
	               break;
	        } else {
	            System.out.println("Invalid Marks Input, try again");
	        }
		}
			  
			}
		 marksList.add(marks);
			System.out.println("Student succesfully added");
		}
	
	static void displayreport() {
		if(Name.isEmpty()==true) {
			System.out.println("No Students were added...Try again after Student added");
			return;
		}
		System.out.println("========== STUDENT REPORT ==========");
		
		for(int i=0;i<Name.size();i++) {
			System.out.println("Student's Name :"+Name.get(i));
		
		Double[] marks=marksList.get(i);
		double sum=0;
		double Average=0;
		boolean passed=true;
			for (int j=0;j<subjects;j++) {
				sum+=marks[j];
				 if (marks[j]<35) {
					passed=false;
					break;
					
				}
				
			}
			Average=sum/subjects;
				System.out.println(Average);
				if(passed) {
					System.out.println("Passed in All subjects");
				}
				else {
					System.out.println("Failed.....");
				}
			}
			
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
	        case 2 -> displayreport();
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
