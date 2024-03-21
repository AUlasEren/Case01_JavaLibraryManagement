package com.ulas.entity;

import com.ulas.enums.EnumStatus;

import java.io.ObjectInputFilter;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int publicationYear;
    protected EnumStatus enumStatus;

    public Book(String isbn, String title, String author, int publicationYear, EnumStatus enumStatus) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.enumStatus = enumStatus;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public EnumStatus getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }
}
