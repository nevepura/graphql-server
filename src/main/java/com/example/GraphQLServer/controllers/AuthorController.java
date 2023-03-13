package com.example.GraphQLServer.controllers;

import com.example.GraphQLServer.model.Author;
import com.example.GraphQLServer.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }

    @QueryMapping
    public Author authorById(@Argument String id) {
        return Author.getById(id);
    }

    @MutationMapping
    public Author saveAuthor(@Argument String id,
                             @Argument String firstName,
                             @Argument String lastName,
                             @Argument Boolean active) {
        return Author.saveAuthor(id, firstName, lastName, active);
    }

    @MutationMapping
    public String deleteAuthorById(@Argument String id) {
        return Author.deleteAuthorById(id);
    }
}
