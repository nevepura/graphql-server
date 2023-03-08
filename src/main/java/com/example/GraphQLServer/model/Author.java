package com.example.GraphQLServer.model;

import java.util.Arrays;
import java.util.List;

public class Author {

    private String id;
    private String firstName;
    private String lastName;

    private Boolean active;

    public Author(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String id, String firstName, String lastName, Boolean active) {
        this(id,firstName,lastName);
        this.active = active;
    }


    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joanne", "Rowling", true),
            new Author("author-2", "Herman", "Melville",false),
            new Author("author-3", "Anne", "Rice", false),
            new Author("author-4", "John Ronald Reuel", "Tolkien", false)
    );

    public static Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

}