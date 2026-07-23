package com.Java.studentgradesystem;


public class Student{
	private String name;
	private Double[]marks;
	private static final int subjects=5;
	
	public Student(String name, Double[] marksDoubles) {
		this.name = name;
		this.marks = marksDoubles;
	}
	public String getName() {return name;}
		
	public Double[] getMarksDoubles() {return marks;}
	
	public double getAverage() {
		double sum=0;
		for (int i=0;i<subjects;i++) {
			sum+=marks[i];
		}
		return sum/subjects;
	}
	public boolean isPassed() {
		for(int j=0;j<subjects;j++) {
			if (marks[j]<35) {
				return false;
			}
		}
		return true;
	}
	public String getGrade() {
		int range=(int)getAverage()/10;
		return switch(range) {
		case 10,9->"A+";
		case 8->"A";
		case 7->"B";
		case 6,5->"C";
		case 4->"D";
		default->"F";
		
		};
	}
	public void printDetails() {
		System.out.println("-------------------------------------------");
		System.out.println("Name :"+name);
		System.out.println("Average :"+ getAverage());
		System.out.println("Result :"+ (isPassed()?"Passed":"Failed"));
		System.out.println("Grade :"+getGrade());
		System.out.println("-------------------------------------------");
	}
}


