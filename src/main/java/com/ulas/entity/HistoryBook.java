package com.ulas.entity;

import com.ulas.enums.EnumStatus;

public class HistoryBook extends Book {
    public HistoryBook(String isbn, String title, String author, int publicationYear) {
        super(isbn, title, author, publicationYear, EnumStatus.AvailableForLoan);
    }
}
