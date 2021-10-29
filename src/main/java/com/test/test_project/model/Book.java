package com.test.test_project.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private int serialNumber;
    private boolean available;

    @ManyToOne
    private Author author;
}
