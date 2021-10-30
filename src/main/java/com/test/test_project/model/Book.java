package com.test.test_project.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @PositiveOrZero
    private int serialNumber;
    private boolean available;

    @ManyToOne
    private Author author;
}
