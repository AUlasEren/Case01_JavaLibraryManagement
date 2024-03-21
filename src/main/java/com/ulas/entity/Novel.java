package com.ulas.entity;

import com.ulas.enums.EnumStatus;

public class Novel extends Book {
    public Novel(String isbn, String title, String author, int publicationYear, EnumStatus enumStatus) {
        super(isbn, title, author, publicationYear, enumStatus);
    }
}
