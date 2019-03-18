package com.learn.bdd.books.services;

import com.learn.bdd.books.exceptions.NotValidException;
import com.learn.bdd.books.models.Author;
import com.learn.bdd.books.repositories.AuthorsRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthorsService {
    private static final Pattern EMAIL_ADDRESS_EXPRESSION =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

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
        if(!isValidEmail(author.getEmail())) {
            throw new NotValidException("Invalid or missing email");
        }
    }

    private boolean isEmpty(String value) {
        return value==null || value.trim().isEmpty();
    }

    private boolean isValidEmail(String email) throws NotValidException {
        if(isEmpty(email)) {
            throw new NotValidException("Invalid or missing email");
        }
        Matcher matcher = EMAIL_ADDRESS_EXPRESSION .matcher(email);
        return matcher.find();
    }
}
