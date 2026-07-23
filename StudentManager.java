package com.Java.studentgradesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	
	 private static final int SUBJECTS = 5;
	    private List<Student> students = new ArrayList<>();
	    private Scanner in = new Scanner(System.in);
	    
	    public void addStudent() {
	    	in.nextLine();
	    	System.out.println("Enter Student Name :");
	    	String name=in.nextLine();
	    	Double[] marks = new Double[SUBJECTS];
	    	for (int i = 0; i < SUBJECTS; i++) {
	            while (true) {
	                System.out.print("Enter Mark for Subject " + (i + 1) + " : ");
	                double temp = in.nextDouble();
	                if (temp >= 0 && temp <= 100) {
	                    marks[i] = temp;
	                     break;
	                } else {
	                    System.out.println("Invalid Marks Input, try again"); 
	                }
	            }
	        }
	   
	    	 students.add(new Student(name, marks));
	    	 System.out.println("Student successfully added!");
	    }
	    
	    public void displayReport() {
	    	if(students.isEmpty()) {
	    		System.out.println("No students were added");
	    		return;
	    	}
	    	System.out.println("================ STUDENT'S REPORT====================");
	    	for(Student s:students) {
	    		s.printDetails();
	    	}
	    }
	    public void searchStudent() {
	        in.nextLine();
	        System.out.print("Enter Student Name : ");
	        String searchName = in.nextLine();
	        boolean found = false;

	     for(Student s : students) {
	               if (s.getName().equalsIgnoreCase(searchName)) { 
	                  System.out.println("========== SEARCH RESULT =========="); 
	                  s.printDetails();
	                    found = true;
	                 break;
	               }
	         
	    }
	    
	     if(!found)
             System.out.println("Student Not Found!");    
}
}
