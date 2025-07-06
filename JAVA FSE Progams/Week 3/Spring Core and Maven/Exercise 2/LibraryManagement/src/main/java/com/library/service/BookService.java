package com.library.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.library.model.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection (Spring will call this method)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showBooks() {
        List<Book> books = bookRepository.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Available Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
