package com.fatmadelenn.elasticsearch.controller;

import com.fatmadelenn.elasticsearch.entity.Book;
import com.fatmadelenn.elasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping
    public Page<Book> allBooks(@PageableDefault(sort = {"id"}, size = 25, page = 0) Pageable pageable) {
        return bookService.allBooks(pageable);
    }

    @GetMapping("/{search}")
    public Page<Book> searchBooks(@PathVariable String search) {
        return bookService.searchBooks(search);
    }

    @GetMapping("/fuzzines/{search}")
    public Page<Book> searchBooksWithFuzzines(@PathVariable String search) {
        return bookService.searchBooksWithFuzzines(search);
    }

    @GetMapping("/multi/{search}")
    public Page<Book> searchBooksWithMultiMatch(@PathVariable String search) {
        return bookService.searchBooksWithMultiMatch(search);
    }
}
