package com.learn.bdd.books.facade.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.bdd.books.controllers.AuthorController;
import com.learn.bdd.books.models.Author;
import com.learn.bdd.books.repositories.AuthorsRepository;
import com.learn.bdd.books.services.AuthorsService;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import javax.lang.model.type.ReferenceType;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class AuthorsSystem {
    public static Integer ADDED_AUTHOR_ID = 245;
    private MockMvc mockMvc;


    public AuthorsSystem(MockMvc mockMvc) {
        this.mockMvc  = mockMvc;
    }

    public static AuthorsSystem create(MockMvc mockMvc) {
        return new AuthorsSystem(mockMvc);
    }

    public ResponseEntity<Author> addAuthor(Author author, Integer authorId) {
        Author newAuthor = new Author(authorId, author);
        try {

            MvcResult mvcResult = this.mockMvc.perform(
                    post("/authors")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(authorToString(newAuthor))
                    .accept(MediaType.APPLICATION_JSON)
                    ).andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            if(response.getStatus() > 400) {
                return new ResponseEntity<>(HttpStatus.valueOf(response.getStatus()));
            }
            String json = mvcResult.getResponse().getContentAsString();
            ObjectMapper objectMapper = new ObjectMapper();
            Author author1 =  objectMapper.readValue(json, Author.class);
            return new ResponseEntity<>(author1, HttpStatus.valueOf(response.getStatus()));
            //return objectMapper.readValue(json, new TypeReference<ResponseEntity<Author>>() {});

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private String authorToString(Author author) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(author);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


}
