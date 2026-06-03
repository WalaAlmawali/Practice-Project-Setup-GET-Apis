package com.example.trainee_app;

public class InventoryBook {

    private int bookId;
    private String title;
    private double price;
    private int stockCount;


    // Constructor

    public InventoryBook(int bookId, String title, double price, int stockCount) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.stockCount = stockCount;
    }

}
