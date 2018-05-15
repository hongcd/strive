package com.hongcd.strive.consumer.service;

import com.hongcd.strive.common.utils.Response;
import com.hongcd.strive.entity.book.Book;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface BookServiceExtension {
    Response findAll() throws ExecutionException, InterruptedException;

    Future<Book> getById(String id);

    List<Book> listAll(Collection<String> ids);
}