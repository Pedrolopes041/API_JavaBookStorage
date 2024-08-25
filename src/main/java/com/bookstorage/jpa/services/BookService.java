package com.bookstorage.jpa.services;

import com.bookstorage.jpa.dto.BookRecordDto;
import com.bookstorage.jpa.modals.Bookmodal;
import com.bookstorage.jpa.modals.ReviewModal;
import com.bookstorage.jpa.repositories.AuthorRepository;
import com.bookstorage.jpa.repositories.BookRepository;
import com.bookstorage.jpa.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private  final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public Bookmodal saveBook(BookRecordDto bookRecordDto) {
        Bookmodal bookmodal = new Bookmodal();

        bookmodal.setTitle(bookRecordDto.title());
        bookmodal.setPublisherModal(publisherRepository.findById(bookRecordDto.publisherId()).get());
        bookmodal.setAuthors(authorRepository.findAllById(bookRecordDto.authorsIds()).stream().collect(Collectors.toSet()));

        ReviewModal reviewModal = new ReviewModal();
        reviewModal.setComment(bookRecordDto.reviewComment());
        reviewModal.setBookmodal(bookmodal);
        bookmodal.setReviewModal(reviewModal);

        return bookRepository.save(bookmodal);
    }

    public List<Bookmodal> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }
}
