package com.test.test_project.facade;

import com.test.test_project.dto.AuthorDTO;
import com.test.test_project.model.Author;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class AuthorFacade {

    public AuthorDTO authorToAuthorDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());
        authorDTO.setMiddleName(author.getMiddleName());
        authorDTO.setDate(author.getDate().toString());
        authorDTO.setBio(author.getBio());
        return authorDTO;
    }

    public Author authorDtoToAuthor(AuthorDTO authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setMiddleName(authorDto.getMiddleName());
        author.setBio(authorDto.getBio());
        if (authorDto.getDate() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
            LocalDate date = LocalDate.parse(authorDto.getDate(), formatter);
            author.setDate(date);
        }
        return author;
    }
}
