package com.test.test_project.service;

import com.test.test_project.dto.AuthorBaseDto;
import com.test.test_project.dto.AuthorDTO;
import com.test.test_project.dto.BookDTO;
import com.test.test_project.facade.BookFacade;
import com.test.test_project.model.Author;
import com.test.test_project.model.Book;
import com.test.test_project.repository.AuthorRepository;
import com.test.test_project.repository.BookRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookFacade bookFacade;

    // Получение всех книг
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> booksDTO = new ArrayList<>();
        for (Book book : books) {
            booksDTO.add(bookFacade.bookToBookDTO(book));
        }
        return booksDTO;
    }

    // Сортировка книг по названию
    public List<BookDTO> getAllBooksByTitle() {
        List<Book> books = bookRepository.findAllByOrderByTitleAsc();
        List<BookDTO> booksDTO = new ArrayList<>();
        for (Book book : books) {
            booksDTO.add(bookFacade.bookToBookDTO(book));
        }
        return booksDTO;
    }

    // Получение всех книг на полке
    public List<BookDTO> getAllBooksByAvailability() {
        List<BookDTO> books = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            if (book.getSerialNumber() > 0) {
                books.add(bookFacade.bookToBookDTO(book));
            }
        }
        return books;
    }

    // Сортировка книг по порядковому номеру
    public List<BookDTO> getAllBooksBySerialNumber() {
        List<Book> books = bookRepository.findAllByOrderBySerialNumberAsc();
        List<BookDTO> booksDTO = new ArrayList<>();
        for (Book book : books) {
            booksDTO.add(bookFacade.bookToBookDTO(book));
        }
        return booksDTO;
    }

    // Получение всех книг автора
    public List<BookDTO> getAuthorBooks(Long id) {
        List<Book> books = bookRepository.findAllByAuthorId(id);
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(bookFacade.bookToBookDTO(book));
        }
        return booksDTO;
    }

    // Добавление книги в библиотеку
    public String addBook(BookDTO bookDto) {
        if (bookRepository.findByTitle(bookDto.getTitle().toLowerCase()) != null)
            return "Book already exist";

        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAvailable(bookDto.isAvailable());
        // Поиск автора по имени и фамилии
        AuthorBaseDto authorBaseDto = bookDto.getAuthor();
        Author author = authorRepository.findByFirstNameAndLastName(authorBaseDto.getFirstName(), authorBaseDto.getLastName());

        if (author == null)
            return "Author dont exist, please add author! \n POST: http://localhost:8080/author/";

        book.setAuthor(author);
        List<Book> books = bookRepository.findAll();
        int serialNumber = 0;

        // Проверяем, ставим ли мы книгу на полку, если да то ищем максимальный порядковый номер и присвиваем следующее по порядку значение
        if (book.isAvailable()) {
            if (books.isEmpty()) {
                serialNumber = 1;
            } else {
                for (Book book1 : books)
                    if (serialNumber < book1.getSerialNumber())
                        serialNumber = book1.getSerialNumber();
                serialNumber++;
            }
        }
        book.setSerialNumber(serialNumber);
        bookRepository.save(book);
        return "Book added successfully";
    }

    // Обновление информации о книге (Название и автор)
    public String updateBook(Long id, BookDTO bookDto) throws NotFoundException {
        Book book = bookRepository.findById(id).orElse(book = null);
        if (book == null)
            return "Book not found!";

        // Если отсутствуют доступные для изменения поля, то возвращаем сообшение
        if (bookDto.getTitle() == null && bookDto.getAuthor() == null)
            return "Nothing to change!";

        if (bookDto.getTitle() != null)
            book.setTitle(bookDto.getTitle());

        if (bookDto.getAuthor() != null) {
            AuthorBaseDto authorDto = bookDto.getAuthor();
            Author author = authorRepository.findByFirstNameAndLastName(authorDto.getFirstName(), authorDto.getLastName());
            if (author != null)
                book.setAuthor(author);
        }
        bookRepository.save(book);
        return "Book updated successfully";
    }

    // Удаление книги с полки
    public String deleteBookFromShelf(Long id) {
        Book book = bookRepository.findById(id).orElse(book = null);
        if (book == null)
            return "Book is not found";

        // Проверка, имеется ли данная книга на полке
        if (!book.isAvailable())
            return "The book is not on the shelf.";

        book.setAvailable(false);
        int serialNumber = book.getSerialNumber();
        // Устанавливаем порядковый номер на 0 и сохранаяем изменения
        book.setSerialNumber(0);
        bookRepository.save(book);

        // Уменьшаем порядковые значения у книг, слудюущих после данной
        for (Book book1 : bookRepository.findAll())
            if (book1.getSerialNumber() > serialNumber) {
                book1.setSerialNumber(book1.getSerialNumber() - 1);
                bookRepository.save(book1);
            }

        return "Book deleted from shelf successfully";
    }

}
