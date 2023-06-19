package com.carmel.json.pojo;

import java.util.List;

public class Author {
    private String author;
    private List<Book> books;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
