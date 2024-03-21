package com.ulas;

import com.ulas.entity.Book;
import com.ulas.entity.Member;
import com.ulas.entity.Novel;
import com.ulas.entity.ScienceBook;
import com.ulas.enums.EnumStatus;
import com.ulas.service.Library;


import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();


        Book book1 = new ScienceBook("123456", "Science Fiction", "Author A", 2020, EnumStatus.AvailableForLoan);
        Book book2 = new Novel("789012", "Great Novel", "Author B", 2019, EnumStatus.AvailableForLoan);


        library.addBook(book1);
        library.addBook(book2);


        Member member1 = new Member("John Doe", library);


        library.addMember(member1);


        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusWeeks(2);
        library.lendBook("123456", member1, borrowDate, dueDate);

        library.listMemberBorrowedBooks(member1);


        LocalDate returnDate = dueDate.plusDays(3);
        library.returnBook("123456", member1, returnDate);


        library.updateBookStatus("789012", EnumStatus.NotAvailable);


        System.out.println("\nAfter returning and updating book status:");
        library.listMemberBorrowedBooks(member1);
    }
}
