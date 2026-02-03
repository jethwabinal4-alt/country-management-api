package com.binal.country.feignclient;

import com.binal.country.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name =  "book-service",
url = "http://localhost:8081/book")

public interface BookFeignClient {

    @GetMapping("/get-book")
    List<Book> getBookList();
}
