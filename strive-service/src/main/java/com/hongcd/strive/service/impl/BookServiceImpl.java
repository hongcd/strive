package com.hongcd.strive.service.impl;

import com.hongcd.strive.dao.BookRepository;
import com.hongcd.strive.entity.book.Book;
import com.hongcd.strive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends GenericServiceImpl<Book, String> implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    protected JpaRepository<Book, String> repository() {
        return bookRepository;
    }
}