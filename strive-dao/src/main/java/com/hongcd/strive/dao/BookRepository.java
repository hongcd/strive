package com.hongcd.strive.dao;

import com.hongcd.strive.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByIdIn(Collection<String> ids);
}