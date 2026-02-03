package com.binal.country.controller;

import com.binal.country.dto.Book;
import com.binal.country.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService  bookService;

    @GetMapping("test")
    public ResponseEntity<List<Book>> getBook(){
        log.info("[BookController] [getBook]  getting all book ");
        List<Book>  bookList = bookService.getBookDetails();
        return new ResponseEntity<>(bookList, HttpStatus.OK) ;
    }


}
