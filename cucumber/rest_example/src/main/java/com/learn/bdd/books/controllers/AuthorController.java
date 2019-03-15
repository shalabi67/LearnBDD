package com.learn.bdd.books.controllers;

import com.learn.bdd.books.models.Author;
import com.learn.bdd.books.services.AuthorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    AuthorsService authorsService;

    public AuthorController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAuthors() {
        return null;
    }

    @PostMapping()
    public ResponseEntity<Author> addAuthor(Author author) {
        if(author == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Author addedAuthor = authorsService.addAuthor(author);
            return new ResponseEntity<>(addedAuthor, HttpStatus.CREATED);
        }catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
