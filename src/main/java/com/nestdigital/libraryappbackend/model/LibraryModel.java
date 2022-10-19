package com.nestdigital.libraryappbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class LibraryModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String author;
    private String pdate;
    private String price;

    public LibraryModel() {
    }

    public LibraryModel(int id, String name, String author, String pdate, String price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pdate = pdate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
