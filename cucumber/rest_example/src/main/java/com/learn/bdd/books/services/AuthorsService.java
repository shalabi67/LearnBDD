package com.learn.bdd.books.services;

import com.learn.bdd.books.exceptions.NotValidException;
import com.learn.bdd.books.models.Author;
import com.learn.bdd.books.repositories.AuthorsRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {
    private AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Author addAuthor(Author author) throws NotValidException{
        validate(author);

        return authorsRepository.save(author);
    }

    private void validate(Author author) throws NotValidException{
        if(isEmpty(author.getFirstName())) {
            throw new NotValidException("First name is required.");
        }
        if(isEmpty(author.getLastName())) {
            throw new NotValidException("Last name is required.");
        }
        if(isEmpty(author.getEmail())) {
            throw new NotValidException("Email is required.");
        }
    }
    private boolean isEmpty(String value) {
        return value==null || value.trim().isEmpty();
    }
}
