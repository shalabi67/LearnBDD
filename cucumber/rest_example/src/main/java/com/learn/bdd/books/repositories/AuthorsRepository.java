package com.learn.bdd.books.repositories;

import com.learn.bdd.books.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
