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

    @GetMapping("/addBookToCatalog")
    public String addBookToCatalog(@RequestParam int id, @RequestParam String title, @RequestParam double price, @RequestParam int stockCount) {

        InventoryBook inventoryBook = new InventoryBook(id, title, price, stockCount);
        catalog.add(inventoryBook);

        return "Book added successfully to the bookstore catalog";
    }

    @GetMapping("/checkStock")
    public String checkStock(@RequestParam int id) {
        for (InventoryBook book : catalog) {
            if (book.getBookId() == id) {
                if (book.getStockCount() > 0) {
                    return "Book Available <br>" + "Title" + book.getTitle() + "<br>" + "Price" + book.getPrice();
                } else {
                    return "Sold Out <br>" + book.getTitle();
                }
            }
        }
        return "This book is not exist in bookstore";
    }

    @GetMapping("/lowStockReport")
    public String lowStockReport(@RequestParam int threshold) {

        StringBuilder report = new StringBuilder();
        for (InventoryBook book : catalog) {
            if (book.getStockCount() <= threshold) {
                report.append("Title: ").append(book.getTitle()).append(" , Stock:").append(book.getStockCount()).append("<br>");

            }
        }
        if (report.length() == 0) {
            return " No books currently need recording";
        }
        return report.toString();
    }

}
