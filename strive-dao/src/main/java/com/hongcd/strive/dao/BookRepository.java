package com.hongcd.strive.dao;

import com.hongcd.strive.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}