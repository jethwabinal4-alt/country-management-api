package com.binal.country.service;

import com.binal.country.dto.Book;
import com.binal.country.dto.BookDto;
import com.binal.country.feignclient.BookFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final  BookFeignClient bookFeignClient;

    public List<Book> addBook(List<Book> bookList){
        return bookFeignClient.addbook(bookList);
    }

    public BookDto addSingleBook(BookDto bookDto){
        return bookFeignClient.addSingleBook(bookDto);
    }

    public List<Book> getBookDetails(){
        return bookFeignClient.getBookList();
    }

    public Book getBookById(int id){
        return bookFeignClient.getBookById(id);
    }

    public BookDto updateBookById(int id,BookDto bookDto){
        return bookFeignClient.updateBookById(id,bookDto);
    }

    public void deleteBookById(int id){
        bookFeignClient.deleteBookById(id);
    }

    public void deleteAllBook(){
        bookFeignClient.deleteAllBook();
    }
}
