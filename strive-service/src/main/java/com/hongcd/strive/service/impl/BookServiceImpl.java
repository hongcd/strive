package com.hongcd.strive.service.impl;

import com.hongcd.strive.common.exception.BusinessException;
import com.hongcd.strive.dao.BookRepository;
import com.hongcd.strive.entity.book.Book;
import com.hongcd.strive.service.BookService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Log4j
@Service
public class BookServiceImpl extends GenericServiceImpl<Book, String> implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> listByIds(Collection<String> ids) {
        try {
            return bookRepository.findByIdIn(ids);
        } catch (Exception e) {
            log.error("Fail to listByIds! " + e.getMessage(), e);
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @Override
    protected JpaRepository<Book, String> repository() {
        return bookRepository;
    }
}