package com.mycompany.lab4polymorphism;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;
import java.util.Comparator;

public class Lab4Polymorphism {

    public static void main(String[] args) {
        Lab4Polymorphism d = new Lab4Polymorphism();
        d.loadStudent();
        d.menu();
    }
    private Vector<Student> a = new Vector<Student>();

    public void addCol() {
        Student b = new College();
        b.Input();
        a.add(b);
        saveStudent();
    }

    public void addUni() {
        Student b = new University();
        b.Input();
        a.add(b);
        saveStudent();
    }

    public void remove() {
        System.out.println("Enter student code :");
        Scanner sc = new Scanner(System.in);
        String c = sc.next();
        for (int i = 0; i < a.size(); i++) {
            if (c.equals(a.get(i).getStudentNum())) {
                a.remove(i);
                break;
            }
        }
        saveStudent();
    }

    public void print() {
        for (int i = 0; i < a.size(); i++) {
            a.get(i).Output();

        }
    }

    public void studentGra() {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).graduation()) {
                a.get(i).Output();
                count++;
            }
        }
        System.out.println("Number of graduated student :" + count);
    }

    public void sortup() {

    }

    public void findStu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word to find students :");
        String d = sc.nextLine();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getStudentFName().contains(d)) {
                a.get(i).Output();
            }
        }
    }

    public void menu() {
        int menu;
        Lab4Polymorphism p = new Lab4Polymorphism();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("1. Add a new college student\n"
                    + "2. Add a new university student\n"
                    + "3. Remove a student from the list\n"
                    + "4. Print student list\n"
                    + "5. Print the list of students eligible for graduation and indicate the number of eligible students\n"
                    + "6. Sort the student list ascending by Student type (College, university) and student code\n"
                    + "7. Find student list by student's full name\n"
                    + "8. Exit\nInput: ");

            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    p.addCol();
                    break;
                case 2:
                    p.addUni();
                    break;
                case 3:
                    p.remove();
                    break;
                case 4:
                    p.print();
                    break;
                case 5:
                    p.studentGra();
                    break;
                case 6:
                    p.sort();
                    break;
                case 7:
                    p.findStu();
                    break;
                case 8:
                    break;
            }
        } while (menu != 8);
    }

    private void sort() {
        Comparator<Student> com = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {

                if (s1 instanceof College && s2 instanceof University) {
                    return -1;
                } else if (s1 instanceof University && s2 instanceof College) {
                    return 1;
                } else {
                    return s1.getStudentNum().compareTo(s2.getStudentNum());
                }
            }
        };
        a.sort(com);
        saveStudent();
    }
    
    String fileName = "Student.Hau";
    public void saveStudent() {
        try {
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(f);
            oStream.writeObject(a);
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error save file"+ e.getMessage());
        }
    }

    public void loadStudent() {
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream inStream = new ObjectInputStream(f);
            a = (Vector<Student>) inStream.readObject();
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error load file");
        }

    }

}
