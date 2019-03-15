package com.learn.bdd.books.facade;

import com.learn.bdd.books.controllers.AuthorController;
import com.learn.bdd.books.models.Author;
import com.learn.bdd.books.repositories.AuthorsRepository;
import com.learn.bdd.books.services.AuthorsService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;

public class AuthorsSystem {
    public static Integer ADDED_AUTHOR_ID = 245;
    private AuthorsRepository authorsRepository;
    private AuthorsService authorsService;
    private AuthorController authorController;

    public AuthorsSystem(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
        authorsService = new AuthorsService(authorsRepository);
        authorController = new AuthorController(authorsService);
    }

    public static AuthorsSystem create(AuthorsRepository authorsRepository) {
        return new AuthorsSystem(authorsRepository);
    }

    public ResponseEntity<Author> addAuthor(Author author, Integer authorId) {
        Author newAuthor = new Author(authorId, author);
        Mockito.when(authorsRepository.save(any())).thenReturn(newAuthor);
        return authorController.addAuthor(author);
    }


}
