package com.springreactive.dto;

import com.springreactive.model.EGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String name;

    private EGenre genre;

    private LocalDateTime releaseDate;
}
