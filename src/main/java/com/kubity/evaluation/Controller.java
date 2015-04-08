package com.kubity.evaluation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class Controller {

    private final Service service = new Service();

    @Path("/author")
	@POST
	public Book addBook(Book book) {
		service.addBook(book);
		return book;
	}

    @Path("/book")
    @GET
    public List<Book> listBook() {
        return service.listBook();
    }

    @Path("/book/{bookid}")
    @GET
    public Book getBook(@PathParam("bookid") Long bookid) {
        return service.getBookById(bookid);
    }

    @Path("/author")
    @POST
    public Author addAuthor(Author author) {
        service.addAuthor(author);
        return author;
    }

    @Path("/author")
    @GET
    public List<Author> listAuthor() {
        return service.listAuthor();
    }

    @Path("/author/{authorid}")
    @GET
    public Author getAuthor(@PathParam("authorid") Long authorId) {
        return service.getAuthorById(authorId);
    }
    
    @Path("/zoubair/{authorid}")
    @GET
    public String getZoubair(@PathParam("authorid") String Name) {
        return Name;
    }
    
    @Path("/author/{authorid}/book")
    @GET
    public List<Book> getAuthorBooks(@PathParam("authorid") Long authorId) {
        return service.getBooksByAuthorId(authorId);
    }

    @Path("/book/{bookid}/{authorid}")
    @PUT
    public Book setAuthor(@PathParam("bookid") Long bookid,
						  @PathParam("authorid") Long authorId) {
        service.setAuthor(bookid, authorId);
        return service.getBookById(bookid);
    }
}
