package com.test.test_project.dto;

import com.test.test_project.util.FormatUtil;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthorBaseDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    public String getFirstName() {
        return FormatUtil.toNameFormat(firstName);
    }

    public String getLastName() {
        return FormatUtil.toNameFormat(lastName);
    }
}
