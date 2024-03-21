package com.ulas.entity;

import com.ulas.enums.EnumStatus;

public class ScienceBook extends Book {
    public ScienceBook(String isbn, String title, String author, int publicationYear, EnumStatus enumStatus) {
        super(isbn, title, author, publicationYear, enumStatus);
    }
}

