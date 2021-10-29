package com.test.test_project.facade;

import com.test.test_project.dto.AuthorBaseDto;
import com.test.test_project.dto.BookDTO;
import com.test.test_project.model.Author;
import com.test.test_project.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BookFacade {

    private final AuthorBaseFacade authorBaseFacade;

    public BookDTO bookToBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAvailable(book.isAvailable());
        bookDTO.setSerialNumber(book.getSerialNumber());

        AuthorBaseDto author = authorBaseFacade.authorToAuthorBaseDto(book.getAuthor());
        bookDTO.setAuthor(author);

        return bookDTO;
    }
}
