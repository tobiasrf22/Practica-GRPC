package com.javainuse.book.service;

import com.javainuse.book.entities.Book;
import com.javainuse.book.entities.Genre;
import com.javainuse.book.repositories.BookRepository;
import com.javainuse.constants.Type;
import com.javainuse.employee.BookRequest;
import com.javainuse.employee.BookResponse;
import com.javainuse.employee.BookServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BookService extends BookServiceGrpc.BookServiceImplBase {

    /**
     * Unary operation to get the book based on book id
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void getBook(BookRequest request, StreamObserver<BookResponse> responseObserver) {

        BookRepository repository = BookRepository.getInstance();

        repository.addBook(Book.builder()
                .id(1L)
                .name("The Alchemist")
                .author("Paulo Coelho")
                .genre(Genre.FICTION)
                .build());
        // We have mocked the employee data.
        // In real world this should be fetched from database or from some other source

        Book book = repository.findById(request.getBookId());
        BookResponse empResp = BookResponse.newBuilder()
                .setBookId(book.getId())
                .setName(book.getName())
                .setGenre(book.getGenre().toString())
                .build();

        // set the response object
        responseObserver.onNext(empResp);

        // mark process is completed
        responseObserver.onCompleted();
    }
}
