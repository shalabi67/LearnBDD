package com.learn.bdd.books.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int authorId;

    private String firstName;
    private String lastName;
    private String email;

    public Author(int authorId, String firstName, String lastName, String email) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Author(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Author(int authorId, Author author) {
        this.authorId = authorId;
        this.firstName = author.firstName;
        this.lastName = author.lastName;
        this.email = author.email;
    }


    public int getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
