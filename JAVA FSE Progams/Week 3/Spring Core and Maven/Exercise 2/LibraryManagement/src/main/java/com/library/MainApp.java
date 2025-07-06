package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the bean with dependency injected
        BookService bookService = (BookService) context.getBean("bookService");

        // Verify that BookRepository was injected
        System.out.println("===== Dependency Injection Test =====");
        bookService.showBooks();
        System.out.println("===== Test Complete =====");
    }
}
