package com.fatmadelenn.elasticsearch.service;

import com.fatmadelenn.elasticsearch.entity.Book;
import com.fatmadelenn.elasticsearch.repository.BookRepository;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.*;

@Service
public class BookService {

    private static final String BOOK_NAME = "bookName";
    private static final String AUTHOR = "author";

    @Autowired
    BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Page<Book> allBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Page<Book> searchBooks(String search) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery(BOOK_NAME, search))
                .build();
        return bookRepository.search(searchQuery);
    }

    public Page<Book> searchBooksWithFuzzines(String search) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery(BOOK_NAME, search)
                        .operator(Operator.AND)
                        .fuzziness(Fuzziness.AUTO)
                        .prefixLength(3))
                .build();
        return bookRepository.search(searchQuery);
    }

    public Page<Book> searchBooksWithMultiMatch(String search) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQuery(search)
                        .field(BOOK_NAME)
                        .field(AUTHOR)
                        .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
                .build();
        return bookRepository.search(searchQuery);
    }
}
