package com.binal.country.feignclient;

import com.binal.country.dto.Book;
import com.binal.country.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name =  "book-service", url = "http://localhost:8080/book")

public interface BookFeignClient {

    @PostMapping("/add-book")
    List<Book> addbook(List<Book> bookList);

    @PostMapping("/add-book1")
    BookDto addSingleBook(BookDto bookDto);

    @GetMapping("/get-book")
    List<Book> getBookList();

    @GetMapping("/getBookById/{id}")
    Book getBookById(@PathVariable int id);

    @PutMapping("/update-book/{id}")
    BookDto updateBookById(@PathVariable int id ,@RequestBody BookDto bookDto);

    @DeleteMapping("/delete-book/{id}")
    Void deleteBookById(@RequestParam("id") int id);

    @DeleteMapping("/deleteAllBook")
    Void deleteAllBook();
}
