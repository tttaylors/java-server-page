package br.com.letscode.javaserverpage.model;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String name;
    private String author;
}

