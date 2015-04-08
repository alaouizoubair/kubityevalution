package com.kubity.evaluation;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class Service {
    static {
        ObjectifyService.register(Book.class);
    }

    public void addAuthor(Author author) {
        ofy().save().entity(author).now();
    }

    public void addBook(Book book) {
        ofy().save().entity(book).now();
    }

    public List<Book> listBook() {
        return ofy().load().type(Book.class).list();
    }

    public Book getBookById(Long id) {
        return ofy().load().type(Book.class).id(id).now();
    }

    public List<Book> getBooksByAuthorId(Long id) {
        Author author = getAuthorById(id);
        return ofy().load().type(Book.class).filter("authorRef =", author).list();
    }

    public List<Author> listAuthor() {
        return ofy().load().type(Author.class).list();
    }

    public Author getAuthorById(Long id) {
        return ofy().load().type(Author.class).id(id).now();
    }

    public void setAuthor(Long bookId, Long authorId) {
        Book book = getBookById(bookId);
        Author author = getAuthorById(authorId);
        Ref<Author> authorRef = Ref.create(author);
        book.setAuthorRef(authorRef);
        addBook(book);
    }
}
