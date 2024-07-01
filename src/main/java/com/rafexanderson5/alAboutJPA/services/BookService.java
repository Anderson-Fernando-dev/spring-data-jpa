package com.rafexanderson5.alAboutJPA.services;

import com.rafexanderson5.alAboutJPA.dtos.BookRecordDto;
import com.rafexanderson5.alAboutJPA.models.BookModel;
import com.rafexanderson5.alAboutJPA.models.PublisherModel;
import com.rafexanderson5.alAboutJPA.models.ReviewModel;
import com.rafexanderson5.alAboutJPA.repositories.AuthorRepository;
import com.rafexanderson5.alAboutJPA.repositories.BookRepository;
import com.rafexanderson5.alAboutJPA.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private AuthorRepository authorRepository;


    public List<BookModel> gellAllBooks(){
        return this.bookRepository.findAll();
    }
    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto){

        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher((PublisherModel) this.publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(this.authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return this.bookRepository.save(book);
    }


    @Transactional
    public void deleteBook(UUID id){
        this.bookRepository.deleteById(id);
    }



}
