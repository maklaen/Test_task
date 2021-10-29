package com.test.test_project.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookDTO {
    private Long id;
    @NotEmpty
    private String title;
    private int serialNumber;
    private boolean available;
    @NotEmpty
    private AuthorBaseDto author;

    public String getTitle() {
        return title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
    }
}
