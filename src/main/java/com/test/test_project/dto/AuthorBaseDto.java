package com.test.test_project.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthorBaseDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    public String getFirstName() {
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    }

    public String getLastName() {
        return lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }
}
