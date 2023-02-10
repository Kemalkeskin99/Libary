package kemalkeskin.libary.core.utılıtıes;

import kemalkeskin.libary.business.responses.BookResponse;
import kemalkeskin.libary.business.responses.ListBookResponse;
import kemalkeskin.libary.entities.concretes.Book;

public class BookModel {
	
	public static ListBookResponse toListBookResponse(Book book) {
		ListBookResponse listBookResponse=new ListBookResponse();
		listBookResponse.setId(book.getId());
		listBookResponse.setName(book.getName());
		listBookResponse.setPrice(book.getPrice());
		listBookResponse.setAuthorId(book.getAuthor().getAuthorId());
		listBookResponse.setPublisherId(book.getPublisher().getPublisherId());
		return listBookResponse;
	}
	
	
	public static BookResponse toBookResponse(Book book) {
		BookResponse bookResponse=new BookResponse();
		bookResponse.setId(book.getId());
		bookResponse.setName(book.getName());
		bookResponse.setPrice(book.getPrice());
		bookResponse.setAuthorId(book.getAuthor().getAuthorId());
		bookResponse.setPublisherId(book.getPublisher().getPublisherId());
		return bookResponse;
	}

}
