package com.mycompany.lab4polymorphism;

import java.util.Scanner;

public class College extends Student {

    private double examScore;

    public College() {
    }

    public College(double examScore) {
        this.examScore = examScore;
    }

    public College(double examScore, String studentNum, String studentFName, int credits, double aScore) {
        super(studentNum, studentFName, credits, aScore);
        this.examScore = examScore;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }
    @Override
    public void Input(){
        super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter graduation exam scores :");
        examScore = sc.nextDouble();
        
    }
    @Override
    public void Output(){
        super.Output();
        System.out.println("| graduation exam scores :"+examScore);
    }

    @Override
    public boolean graduation() {
        if (super.graduation() == true) {
            if (getCredits() >= 100 & getExamScore() >= 5) {
                return true;
            }
        }
        return false;

    }

}
