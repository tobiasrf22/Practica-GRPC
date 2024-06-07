package com.javainuse.book.repositories;

import com.javainuse.book.entities.Book;
import com.javainuse.book.entities.Genre;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static List<Book> books = new ArrayList<>();
    private static BookRepository instance;

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public static Book findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);
    }

}