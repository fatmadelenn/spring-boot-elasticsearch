package com.fatmadelenn.elasticsearch.repository;

import com.fatmadelenn.elasticsearch.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Long> {
}