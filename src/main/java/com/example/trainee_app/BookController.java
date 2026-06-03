package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private static List<Book> books = new ArrayList<>();

    // add book

    @GetMapping("/add-book")
    public String addBook(@RequestParam int id, @RequestParam String name) {
        Book book = new Book(id, name);
        books.add(book);
        return "Book added successfully!";
    }

    // get all books

    @GetMapping("/all-books")
    public List<Book> getAllBooks() {
        return books;
    }

    // search by id

    @GetMapping("/find-by-id")
    public Book findById(@RequestParam int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // search by name

    @GetMapping("/find-by-name")
    public Book findByName(@RequestParam String name) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

    // search message
    @GetMapping("/search-msg")
    public String searchMessage(@RequestParam int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return "Found:" + book.getName();
            }
        }
        return "Sorry, the book ID is not available.";
    }
}
