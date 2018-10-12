package com.hongcd.strive.consumer.collapser.book;

import com.hongcd.strive.consumer.command.book.BookListByIdsCommand;
import com.hongcd.strive.consumer.service.BookServiceExtension;
import com.hongcd.strive.entity.book.Book;
import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HongD
 */
@Slf4j
public class BookListByIdsCollapseCommand extends HystrixCollapser<List<Book>, Book, String> {
    private BookServiceExtension bookServiceExtension;
    private String id;

    public BookListByIdsCollapseCommand(BookServiceExtension bookServiceExtension, String id) {
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("BookListByIdsCollapseCommand")).andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(100)));
        this.bookServiceExtension = bookServiceExtension;
        this.id = id;
    }

    @Override
    public String getRequestArgument() {
        return id;
    }

    @Override
    protected HystrixCommand<List<Book>> createCommand(Collection<CollapsedRequest<Book, String>> collapsedRequests) {
        return new BookListByIdsCommand(bookServiceExtension, collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
    }

    @Override
    protected void mapResponseToRequests(List<Book> batchResponse, Collection<CollapsedRequest<Book, String>> collapsedRequests) {
        log.info("mapResponseToRequests");
        int count = 0;
        for (CollapsedRequest<Book, String> collapsedRequest : collapsedRequests) {
            collapsedRequest.setResponse(batchResponse.get(count++));
        }
    }
}