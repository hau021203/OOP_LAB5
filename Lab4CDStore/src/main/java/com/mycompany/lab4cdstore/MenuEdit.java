package com.mycompany.lab4cdstore;
import java.io.Serializable;
import java.util.*;
public class MenuEdit implements Serializable {
    private String CDId;
    private String CDCollection;
    private String CDType;
    private String Title;
    private int Price;
    private int YearOfRe;
    public MenuEdit(){}
    public MenuEdit(String CDId, String CDCollection, String CDType, String Title, int Price, int YearOfRe) {
        this.CDId = CDId;
        this.CDCollection = CDCollection;
        this.CDType = CDType;
        this.Title = Title;
        this.Price = Price;
        this.YearOfRe = YearOfRe;
    }
    public void InputCD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CD id :");
        CDId = sc.next();
        System.out.println("Enter CD collection (game/movie/music) :");
        CDCollection = sc.next();
        System.out.println("Enter CD type (audio/video) :");
        CDType = sc.next();
        System.out.println("Enter CD title :");
        sc.nextLine();
        Title = sc.nextLine();
        System.out.println("Enter CD price :");
        Price = sc.nextInt();
        System.out.println("Enter the year CD release :");
        YearOfRe = sc.nextInt();
    }
    public String OutputCD(){
        return"Id :"+CDId+" | Collection :"+CDCollection+" | Type :"+CDType+" | Title :"+Title+" | Price :"+Price+" | Year of release :"+YearOfRe;
    }

    public String getCDId() {
        return CDId;
    }

    public void setCDId(String CDId) {
        this.CDId = CDId;
    }

    public String getCDCollection() {
        return CDCollection;
    }

    public void setCDCollection(String CDCollection) {
        this.CDCollection = CDCollection;
    }

    public String getCDType() {
        return CDType;
    }

    public void setCDType(String CDType) {
        this.CDType = CDType;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getYearOfRe() {
        return YearOfRe;
    }

    public void setYearOfRe(int YearOfRe) {
        this.YearOfRe = YearOfRe;
    }
    

    
    
}
