package com.hongcd.strive.service;

import com.hongcd.strive.entity.book.Book;

import java.util.Collection;
import java.util.List;

/**
 * 图书服务接口
 */
public interface BookService extends GenericService<Book, String> {
    List<Book> listByIds(Collection<String> ids);
}