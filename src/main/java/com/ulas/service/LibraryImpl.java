package com.ulas.service;

import com.ulas.entity.Book;
import com.ulas.entity.Member;
import com.ulas.enums.EnumStatus;

import java.time.LocalDate;

public interface LibraryImpl {
    void addMember(Member member);
    void addBook(Book book);
    boolean lendBook(String isbn, Member member, LocalDate borrowDate, LocalDate dueDate);
    boolean returnBook(String isbn, Member member, LocalDate returnDate);
    void updateBookStatus(String isbn, EnumStatus newStatus);
    void listMemberBorrowedBooks(Member member);
}
