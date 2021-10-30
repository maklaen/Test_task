package com.test.test_project.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.test_project.util.FormatUtil;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthorDTO extends AuthorBaseDto {
    private String middleName;
    private String bio;
    private String date;
    private Long id;

    public String getMiddleName() {
        if (middleName != null) {
            return FormatUtil.toNameFormat(middleName);
        } else {
            return null;
        }

    }
}
