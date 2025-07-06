package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void displayBookData() {
        System.out.println("Fetching book data from database...");
    }
}
