package com.test.test_project.controller;

import com.test.test_project.dto.AuthorDTO;
import com.test.test_project.service.AuthorService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/")
    public AuthorDTO addAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.addAuthor(authorDTO);
    }

    @GetMapping("/")
    public List<AuthorDTO> allAuthor() {
        return authorService.getAllAuthors();
    }

    @PutMapping("/{id}")
    public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) throws NotFoundException {
        return authorService.updateAuthor(id, authorDTO);
    }
}
