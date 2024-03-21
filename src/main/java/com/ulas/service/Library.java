package com.ulas.service;

import com.ulas.entity.Book;
import com.ulas.entity.BorrowedBook;
import com.ulas.entity.Member;
import com.ulas.enums.EnumStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements LibraryImpl {
    private Map<Book, BorrowedBook> borrowedBooks = new HashMap<>();
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private Map<Member, List<Book>> memberBooks = new HashMap<>();
    @Override
    public void addBook(Book book) {
        books.add(book);
    }
    @Override
    public void addMember(Member member) {
        members.add(member);
        memberBooks.put(member, new ArrayList<>());
    }
@Override
public boolean lendBook(String isbn, Member member, LocalDate borrowDate, LocalDate dueDate) {
    for (Book book : books) {
        if (book.getIsbn().equals(isbn) && book.getEnumStatus() == EnumStatus.AvailableForLoan) {
            book.setEnumStatus(EnumStatus.LentOut);
            BorrowedBook borrowedBook = new BorrowedBook(book, borrowDate, dueDate);
            borrowedBooks.put(book, borrowedBook); // Kitabı ödünç alınan kitaplar listesine ekleyin
            return true;
        }
    }
    return false;
}
    @Override
    public boolean returnBook(String isbn, Member member, LocalDate returnDate) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.getEnumStatus() == EnumStatus.LentOut) {
                BorrowedBook borrowedBook = borrowedBooks.get(book);
                LocalDate dueDate = borrowedBook.getDueDate();
                double penalty = PenaltySystem.calculatePenalty(dueDate, returnDate);

                if (penalty > 0) {
                    System.out.println("Late return penalty for " + book.getTitle() + ": " + penalty);
                    // Gerekiyorsa üye üzerinde bir ceza kaydı oluşturun
                }

                book.setEnumStatus(EnumStatus.AvailableForLoan);
                borrowedBooks.remove(book); // Kitabı ödünç alınan kitaplar listesinden çıkarın
                return true;
            }
        }
        return false;
    }
    @Override
    public void updateBookStatus(String isbn, EnumStatus newStatus) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setEnumStatus(newStatus);
                System.out.println("Status of book with ISBN " + isbn + " has been updated to " + newStatus);
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    @Override
    public void listMemberBorrowedBooks(Member member) {
        List<Book> borrowedBooks = memberBooks.getOrDefault(member, new ArrayList<>());
        if (borrowedBooks.isEmpty()) {
            System.out.println(member.getName() + " has not borrowed any books.");
            return;
        }
        System.out.println("Books borrowed by " + member.getName() + ":");
        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle());
        }
    }
}
