package com.test.test_project.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "Author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[a-zA-ZА-Яа-яёЁ]+")
    private String firstName;
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[a-zA-ZА-Яа-яёЁ]+")
    private String lastName;
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[a-zA-ZА-Яа-яёЁ]+")
    private String middleName;
    private LocalDate date;
    @Column(columnDefinition = "text")
    private String bio;
}
