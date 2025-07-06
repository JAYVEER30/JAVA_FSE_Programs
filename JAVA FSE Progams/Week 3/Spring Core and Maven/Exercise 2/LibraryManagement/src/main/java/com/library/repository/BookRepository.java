package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.library.model.Book;

@Repository
public class BookRepository {

    // Simulated database using a list
    private List<Book> bookList;

    public BookRepository() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "Wings of Fire", "Dr. A.P.J. Abdul Kalam"));
        bookList.add(new Book(2, "Gitanjali", "Rabindranath Tagore"));
        bookList.add(new Book(3, "How to Talk to Anyone", "McGraw-Hill"));

    }

    // Simulates fetching data from a DB
    public List<Book> getAllBooks() {
        return bookList;
    }
}
