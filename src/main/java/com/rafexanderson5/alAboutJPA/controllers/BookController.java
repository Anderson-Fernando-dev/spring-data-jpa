package com.rafexanderson5.alAboutJPA.controllers;

import com.rafexanderson5.alAboutJPA.dtos.BookRecordDto;
import com.rafexanderson5.alAboutJPA.models.BookModel;
import com.rafexanderson5.alAboutJPA.repositories.BookRepository;
import com.rafexanderson5.alAboutJPA.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    @Autowired
    private  BookService bookService;




    @GetMapping
    public ResponseEntity<List<BookModel>> allBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.gellAllBooks());
    }
    @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto bookRecordDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.saveBook(bookRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id){
        this.bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted Successufully");
    }

}
