package com.example.GraphQLServer.controllers;

import com.example.GraphQLServer.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> booksByGenre(@Argument String genre) {
        return Book.getByGenre(genre);
    }

    @MutationMapping
    public Book saveBook(@Argument String id,
                         @Argument String name,
                         @Argument int pageCount,
                         @Argument String authorId,
                         @Argument String genre) {
        return Book.store(id, name, pageCount, authorId, genre);
    }


}