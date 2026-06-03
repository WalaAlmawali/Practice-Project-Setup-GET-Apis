package com.example.trainee_app;

public class Book {
    private int id;
    private String name;
    private int authorId;

    //Constructor

    public Book(int id, String name, int authorId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
    }


    // Getter and Setter for booth id and name

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
