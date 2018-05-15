package com.hongcd.strive.consumer.command.book;

import com.hongcd.strive.consumer.service.BookServiceExtension;
import com.hongcd.strive.entity.book.Book;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import java.util.List;

public class BookListByIdsCommand extends HystrixCommand<List<Book>> {
    private BookServiceExtension bookServiceExtension;
    private List<String> bookIds;

    public BookListByIdsCommand(BookServiceExtension bookServiceExtension, List<String> bookIds) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("bookCommand")).andCommandKey(HystrixCommandKey.Factory.asKey("listByIds")));
        this.bookServiceExtension = bookServiceExtension;
        this.bookIds = bookIds;
    }

    @Override
    protected List<Book> run() {
        return bookServiceExtension.listByIds(bookIds);
    }
}
