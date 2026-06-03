package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    private static List<Author> authorList = new ArrayList<>();
    private static List<Book> bookList = new ArrayList<>();

    // add author

    @GetMapping("/addAuthor")
    public String addAuthor(@RequestParam int id, @RequestParam String name, @RequestParam String biography) {

        Author author = new Author(id, name, biography);
        authorList.add(author);

        return "Author added successfully";
    }

    // get all authors

    @GetMapping("/allAuthors")
    public List<Author> getAllAuthors() {
        return authorList;
    }

    @GetMapping(" /addRelationalBook")
    public String addRelationalBook(@RequestParam int id, @RequestParam String name, @RequestParam int authorId) {

        boolean authorExist = false;

        for (Author author : authorList) {
            if (author.getId() == authorId) {
                authorExist = true;
                break;
            }
        }
        if (authorExist) {
            Book book = new Book(id, name, authorId);
            bookList.add(book);
            return "Book added successfully";
        } else {
            return "Error: Author ID does not exist in the author registry";
        }
    }
}
