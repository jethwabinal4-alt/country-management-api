package com.binal.country.service;

import com.binal.country.dto.Book;
import com.binal.country.feignclient.BookFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final  BookFeignClient bookFeignClient;

    public List<Book> getBookDetails(){
       return bookFeignClient.getBookList();
    }
}
