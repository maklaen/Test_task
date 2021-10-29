package com.test.test_project.facade;

import com.test.test_project.dto.AuthorBaseDto;
import com.test.test_project.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorBaseFacade {
    public AuthorBaseDto authorToAuthorBaseDto(Author author) {
        AuthorBaseDto authorBase = new AuthorBaseDto();
        authorBase.setFirstName(author.getFirstName());
        authorBase.setLastName(author.getLastName());
        return authorBase;
    }
}
