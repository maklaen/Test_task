package com.test.test_project.repository;

import com.test.test_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorId(Long authorId);

    Book findByTitle(String title);

    List<Book> findAllByOrderByTitleAsc();

    List<Book> findAllByOrderBySerialNumberAsc();
}