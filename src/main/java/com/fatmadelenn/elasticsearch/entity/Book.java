package com.fatmadelenn.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "book")
public class Book {

    @Id
    private Long id;

    @Field(name = "bookName",type = FieldType.Text)
    private String bookName;

    @Field(name = "author",type = FieldType.Text)
    private String author;

    @Field(name = "pageSize",type = FieldType.Integer)
    private int pageSize;

    @Field(name = "publisher",type = FieldType.Text)
    private String publisher;

    public Book() {
    }

    public Book(Long id, String bookName, String author, int pageSize, String publisher) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.pageSize = pageSize;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", pageSize=" + pageSize +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}