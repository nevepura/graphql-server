package com.example.GraphQLServer.model;

import org.springframework.graphql.data.method.annotation.Argument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Author {
    private static List<Author> authors = new ArrayList<>();

    static {
        authors.add(new Author("author-1", "Joanne", "Rowling", true));
        authors.add(new Author("author-2", "Herman", "Melville", false));
        authors.add(new Author("author-3", "Anne", "Rice", false));
        authors.add(new Author("author-4", "John Ronald Reuel", "Tolkien", false));
    }

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
        this(id, firstName, lastName);
        this.active = active;
    }


    public static Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

    public static Author saveAuthor(String id,
                                    String firstName,
                                    String lastName,
                                    Boolean active) {
        Author newAuthor = new Author(id, firstName, lastName, active);
        authors.add(newAuthor);
        return newAuthor;
    }

    public static String deleteAuthorById(String id) {
        Author author = Author.getById(id);
        authors.remove(author);
        return id;
    }

}