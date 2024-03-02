package com.mycompany.lab4polymorphism;

import java.io.Serializable;
import java.util.Scanner;

public  class Student implements Serializable {

    private String studentNum;
    private String studentFName;
    private int credits;
    private double aScore;

    public Student() {
    }

    public Student(String studentNum, String studentFName, int credits, double aScore) {
        this.studentNum = studentNum;
        this.studentFName = studentFName;
        this.credits = credits;
        this.aScore = aScore;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentFName() {
        return studentFName;
    }

    public void setStudentFName(String studentFName) {
        this.studentFName = studentFName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getaScore() {
        return aScore;
    }

    public void setaScore(double aScore) {
        this.aScore = aScore;
    }

    public void Input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student number :");
        studentNum = sc.next();
        System.out.println("Enter student's full name :");
        sc.nextLine();
        studentFName = sc.nextLine();
        System.out.println("Enter total number of credits earned :");
        credits = sc.nextInt();
        System.out.println("Enter average score :");
        aScore = sc.nextDouble();
    }

    public void Output() {
        System.out.print("student number :"+studentNum+"| student's full name :"+studentFName+"| credits :"+credits+"| average score :"+aScore);
    }

    public boolean graduation(){
        if(getaScore()>=5.0)
            return true;
        return false;
    }
        
    
}
