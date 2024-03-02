package com.mycompany.lab4polymorphism;
import java.util.Scanner;
public class University extends Student {
    private String thesisName;
    private double thesisScore;
    public University(){}
    public University(String thesisName, double thesisScore) {
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }

    public University(String thesisName, double thesisScore, String studentNum, String studentFName, int credits, double aScore) {
        super(studentNum, studentFName, credits, aScore);
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }

    public String getThesisName() {
        return thesisName;
    }

    public void setThesisName(String thesisName) {
        this.thesisName = thesisName;
    }

    public double getThesisScore() {
        return thesisScore;
    }

    public void setThesisScore(double thesisScore) {
        this.thesisScore = thesisScore;
    }
    @Override
    public void Input(){
        super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter thesis name :");
        thesisName = sc.nextLine();
        System.out.println("Enter thesis score :");
        thesisScore = sc.nextDouble();
    }
    @Override
    public void Output(){
        super.Output();
        System.out.println("| thesis Name :"+thesisName+"| thesis Score :"+thesisScore);
    }
    @Override
    public boolean graduation() {
        if (super.graduation() == true) {
            if (getCredits() >= 150 & getThesisScore() >= 5) {
                return true;
            }
        }
        return false;

    }
}
