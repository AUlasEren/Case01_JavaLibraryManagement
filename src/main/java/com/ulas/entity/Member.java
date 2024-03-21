package com.ulas.entity;

import com.ulas.service.Library;

import java.time.LocalDate;


public class Member implements MemberImpl {
    private String name;
    private Library library;
    public Member(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    public String getName() {
        return name;
    }

    @Override
    public void borrowBook(Book book) {
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusWeeks(2);
        if (library.lendBook(book.getIsbn(), this, borrowDate, dueDate)) {
            System.out.println(book.getTitle() + " has been successfully borrowed by " + name + ". Return by " + dueDate + ".");
        } else {
            System.out.println("Failed to borrow " + book.getTitle());
        }
    }

    @Override
    public void returnBook(Book book) {
        LocalDate returnDate = LocalDate.now();
        if (library.returnBook(book.getIsbn(), this, returnDate)) {
            System.out.println(book.getTitle() + " has been successfully returned by " + name);
        } else {
            System.out.println("Failed to return " + book.getTitle());
        }
    }
}


