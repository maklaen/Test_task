package com.test.test_project.service;

import com.test.test_project.dto.AuthorDTO;
import com.test.test_project.facade.AuthorFacade;
import com.test.test_project.model.Author;
import com.test.test_project.repository.AuthorRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorFacade authorFacade;

    // Добавление автора в список авторов
    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        if (authorDTO.getFirstName() == null || authorDTO.getLastName() == null) {
            throw new IllegalArgumentException("The first and last name should not be empty!");
        }
        if (authorRepository.findByFirstNameAndLastName(authorDTO.getFirstName(), authorDTO.getLastName()) != null) {
            throw new IllegalArgumentException("Author already exist!");
        }
        Author author = authorFacade.authorDtoToAuthor(authorDTO);
        authorRepository.save(author);
        return authorDTO;
    }

    // Получение списка всех авторов
    public List<AuthorDTO> getAllAuthors() {

        List<AuthorDTO> authorDto = new ArrayList<>();
        for (Author author : authorRepository.findAll()) {
            authorDto.add(authorFacade.authorToAuthorDTO(author));
        }
        return authorDto;
    }

    // Обновление информации об авторе
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) throws NotFoundException {
        if (authorDTO.getFirstName() == null || authorDTO.getLastName() == null) {
            throw new IllegalArgumentException("The first and last name should not be empty!");
        }

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author not found"));

        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setMiddleName(authorDTO.getMiddleName());
        author.setBio(authorDTO.getBio());
        LocalDate date;
        if (authorDTO.getDate() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
            date = LocalDate.parse(authorDTO.getDate(), formatter);
            author.setDate(date);
        }
        authorRepository.save(author);
        return authorFacade.authorToAuthorDTO(author);
    }
}
