package com.example.GraphQLServer.controllers;

import com.example.GraphQLServer.model.Author;
import com.example.GraphQLServer.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
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

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }

    @QueryMapping
    public Author authorById(@Argument String id){
        return Author.getById(id);
    }

    @QueryMapping
    public List<Book> booksByGenre(@Argument String genre){
        return Book.getByGenre(genre);
    }

}