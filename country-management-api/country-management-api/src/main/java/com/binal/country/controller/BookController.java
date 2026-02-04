package com.binal.country.controller;

import com.binal.country.dto.Book;
import com.binal.country.dto.BookDto;
import com.binal.country.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService  bookService;

    @PostMapping("/add-book")
    public ResponseEntity<List<Book>> addBook(@RequestBody List<Book> bookList){
        log.info("[BookController] [addBook]  adding book ");
        List<Book> book1 = bookService.addBook(bookList);
        return new ResponseEntity<>(book1,HttpStatus.CREATED);
    }

    @PostMapping("/add-book1")
    public ResponseEntity<BookDto> addSingleBook(@RequestBody BookDto bookDto){
        log.info("[BookController] [addSingleBook]  adding single book ");
        BookDto bookDto1 = bookService.addSingleBook(bookDto);
        return new ResponseEntity<>(bookDto1,HttpStatus.CREATED);
    }

    @GetMapping("/get-book")
    public ResponseEntity<List<Book>> getBook(){
        log.info("[BookController] [getBook]  getting all book ");
        List<Book>  bookList = bookService.getBookDetails();
        return new ResponseEntity<>(bookList,HttpStatus.OK) ;
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        log.info("[BookController] [getBookById]  getting book by id");
        Book bookById = bookService.getBookById(id);
        return new ResponseEntity<>(bookById,HttpStatus.OK);
    }

    @PutMapping("update-book/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable int id,@RequestBody BookDto book){
        log.info("[BookController] [updateBook]  Updating book byb id{}",id);
        BookDto book1 =  bookService.updateBookById(id , book);
        return new ResponseEntity<>(book1,HttpStatus.ACCEPTED) ;
    }

    @DeleteMapping("delete-book/{id}")
    public ResponseEntity<?> deleteBook(@RequestParam("id") int id){
        log.info("[BookController] [deleteBook]  deleting book  by id {}",id);
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }

    @DeleteMapping("deleteAllBook")
    public ResponseEntity<?>  deleteAllBook(){
        log.info("[BookController] [deleteAllBook]  Deleting all book");
        bookService.deleteAllBook();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }
}
