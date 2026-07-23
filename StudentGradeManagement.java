package com.Java.studentgradesystem;

import java.util.Scanner;

public class StudentGradeManagement{
    public static void main(String[] args) {
    	StudentManager manager=new StudentManager();
        boolean run = true;
Scanner in= new Scanner(System.in);
        while (run) {
            System.out.println("----------- MENU -----------");
            System.out.println("1. Add Student");
            System.out.println("2. Display Report");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choose = in.nextInt();
            switch (choose) {
                case 1 -> manager.addStudent();
                case 2 -> manager.displayReport();
                case 3 -> manager.searchStudent();
                case 4 -> {
                    System.out.println("Exit...");
                    run = false;
                }
                default -> System.out.println("Invalid Input Try With Valid options");
            }
        }
    }
}
