package com.ulas.service;

import com.ulas.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class SearchUtility {

    public static List<Book> searchByTitle(List<Book> books, String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

}
