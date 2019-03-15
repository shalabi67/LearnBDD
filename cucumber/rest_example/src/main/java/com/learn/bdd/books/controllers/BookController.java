package com.learn.bdd.books.controllers;

import com.learn.bdd.books.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return null;
    }
}
