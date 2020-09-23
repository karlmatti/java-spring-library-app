package matti.karl.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        System.out.println("In LibraryApplication BEFORE SpringApplication.run");
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("In LibraryApplication AFTER SpringApplication.run");
    }

}
