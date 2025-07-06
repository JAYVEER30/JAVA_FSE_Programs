package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("===== Starting Spring Application =====");

        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Spring context loaded successfully.");

        // Get bean
        TestService testService = (TestService) context.getBean("testService");
        System.out.println("TestService bean retrieved from Spring container.");
        System.out.println("Calling testService.testSpring()...");

        // Call method
        testService.testSpring();

        System.out.println("===== Spring Application Finished =====");
    }
}
