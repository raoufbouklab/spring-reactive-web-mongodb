package com.springreactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private String id;

    private String name;

    private EGenre genre;

    private LocalDateTime releaseDate;

    public Book(String name, EGenre genre, LocalDateTime releaseDate) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }
}
