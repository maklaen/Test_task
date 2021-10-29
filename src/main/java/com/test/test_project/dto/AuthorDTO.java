package com.test.test_project.dto;
import lombok.Data;

@Data
public class AuthorDTO extends AuthorBaseDto {
    private String middleName;
    private String bio;
    private String date;
    private Long id;

    public String getMiddleName() {
        return middleName.substring(0, 1).toUpperCase() + middleName.substring(1).toLowerCase();
    }
}
