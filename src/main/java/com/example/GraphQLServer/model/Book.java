package com.example.GraphQLServer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1", "fantasy"));
        books.add(new Book("book-2", "Moby Dick", 635, "author-2", "fiction"));
        books.add(new Book("book-3", "Interview with the vampire", 371, "author-3", "fiction"));
        books.add(new Book("book-4", "Lord of the rings", 1500, "author-4", "fantasy"));
    }

    private String id;
    private String name;
    private int pageCount;
    private String authorId;
    private String genre;


    public Book(String id, String name, int pageCount, String authorId) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }

    public Book(String id, String name, int pageCount, String authorId, String genre) {
        this(id, name, pageCount, authorId);
        this.genre = genre;
    }

    public static Book store(String id, String name, int pageCount, String authorId, String genre) {
        Book b = new Book(id, name, pageCount, authorId, genre);
        books.add(b);
        return b;
    }


    public static Book getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthorId() {
        return authorId;
    }

    public static List<Book> getByGenre(String genre) {
        return books.stream().filter(book -> genre.equals(book.getGenre())).collect(Collectors.toList());
    }
}
