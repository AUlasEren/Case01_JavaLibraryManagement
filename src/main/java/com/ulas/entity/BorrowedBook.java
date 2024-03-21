package com.ulas.entity;

import java.time.LocalDate;

public class BorrowedBook {
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public BorrowedBook(Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
