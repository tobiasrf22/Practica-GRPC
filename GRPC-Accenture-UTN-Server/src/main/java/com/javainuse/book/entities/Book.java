package com.javainuse.book.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private Long id;

    private String name;

    private String author;

    private Genre genre;


}
