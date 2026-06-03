package com.example.trainee_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreController {

    private static List<InventoryBook> catalog = new ArrayList<>();

    @GetMapping("/addBook")
    public String addBook(@RequestParam int id, @RequestParam String title, @RequestParam double price, @RequestParam int stockCount) {

        InventoryBook inventoryBook = new InventoryBook(id, title, price, stockCount);
        catalog.add(inventoryBook);

        return "Book added successfully to the bookstore catalog";
    }


}
