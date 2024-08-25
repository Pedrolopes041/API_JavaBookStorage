package com.bookstorage.jpa.controllers;

import com.bookstorage.jpa.dto.BookRecordDto;
import com.bookstorage.jpa.modals.Bookmodal;
import com.bookstorage.jpa.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Bookmodal> saveBook(@RequestBody BookRecordDto bookRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecordDto));
    }

    @GetMapping
    public  ResponseEntity<List<Bookmodal>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.getAllBooks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);

        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully!");
    }
}


