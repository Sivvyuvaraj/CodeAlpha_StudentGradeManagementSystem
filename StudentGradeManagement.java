package com.Java.studentgradesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeManagement {
    static final int subjects = 5;
    static List<String> Name = new ArrayList<String>();
    static List<Double[]> marksList = new ArrayList<Double[]>();
    static Scanner in = new Scanner(System.in);
    static void printStudentDetails(int i) {
        Double[] marks = marksList.get(i);
        double sum = 0;
        boolean passed = true;

        // Loop 1: sum calculate
        for (int j = 0; j < subjects; j++) {
            sum += marks[j];
        }

        // Loop 2: pass/fail check
        for (int j = 0; j < subjects; j++) {
            if (marks[j] < 35) {
                passed = false;
                break;
            }
        }

        double Average = sum / subjects;
        int range = (int) Average / 10;
        String grade = switch (range) {
            case 10, 9 -> "Grade : A+";
            case 8 -> "Grade : A";
            case 7 -> "Grade : B";
            case 6, 5 -> "Grade : C";
            case 4 -> "Grade : D";
            default -> "Grade : F";
        };

        System.out.println("-----------------------------------");
        System.out.println("Name    : " + Name.get(i));
        System.out.println("Average : " + Average);
        System.out.println("Result  : " + (passed ? "Passed" : "Failed"));
        System.out.println(grade);
        System.out.println("-----------------------------------");
    }
    static void addstudent() {
        in.nextLine();
        System.out.println("Enter Student Name");
        Name.add(in.nextLine());
        Double[] marks = new Double[subjects];

        for (int i = 0; i < subjects; i++) {
            while (true) {
                System.out.print("Enter Mark for Subject " + (i + 1) + ":");
                double temp = in.nextDouble();
                if (temp >= 0 && temp <= 100) {
                    marks[i] = temp;
                    break;
                } else {
                    System.out.println("Invalid Marks Input, try again");
                }
            }
        }
        marksList.add(marks);
        System.out.println("Student successfully added");
    }
    static void displayreport() {
        if (Name.isEmpty()) {
            System.out.println("No Students added yet!");
            return;
        }
        System.out.println("========== STUDENT REPORT ==========");
        for (int i = 0; i < Name.size(); i++) {
            printStudentDetails(i); // helper method call
        }
    }
    static void searchStudent() {
        in.nextLine();
        System.out.print("Enter Student Name : ");
        String searchName = in.nextLine();
        boolean found = false;
        int i = 0;

        while (i < Name.size()) {
            if (Name.get(i).equalsIgnoreCase(searchName)) {
                System.out.println("========== SEARCH RESULT ==========");
                printStudentDetails(i); // same helper method call
                found = true;
                break;
            }
            i++;
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }
    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("----------- MENU -----------");
            System.out.println("1. Add Student");
            System.out.println("2. Display Report");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choose = in.nextInt();
            switch (choose) {
                case 1 -> addstudent();
                case 2 -> displayreport();
                case 3 -> searchStudent();
                case 4 -> {
                    System.out.println("Exit...");
                    run = false;
                }
                default -> System.out.println("Invalid Input Try With Valid options");
            }
        }
    }
}
