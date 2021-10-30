package com.test.test_project.controller;

import com.test.test_project.dto.BookDTO;
import com.test.test_project.service.BookService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/")
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @GetMapping("/")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/available")
    public List<BookDTO> getAllBooksSortedByAvailability() {
        return bookService.getAllBooksByAvailability();
    }

    @GetMapping("/title")
    public List<BookDTO> getAllBooksSortedByTitle() {
        return bookService.getAllBooksByTitle();
    }

    @GetMapping("/serial")
    public List<BookDTO> getAllBooksSortedBySerialNumber() {
        return bookService.getAllBooksBySerialNumber();
    }

    @GetMapping("/author/{id}")
    public List<BookDTO> getAllAuthorsBooks(@PathVariable Long id) {
        return bookService.getAuthorBooks(id);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) throws NotFoundException {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public BookDTO deleteBookFromShelf(@PathVariable Long id) throws Exception {
        return bookService.deleteBookFromShelf(id);
    }
}
