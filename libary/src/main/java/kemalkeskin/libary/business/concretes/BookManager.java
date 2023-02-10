package kemalkeskin.libary.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.libary.business.abstracts.AuthorService;
import kemalkeskin.libary.business.abstracts.BookService;
import kemalkeskin.libary.business.abstracts.PublisherService;
import kemalkeskin.libary.business.requests.CreateBookRequest;
import kemalkeskin.libary.business.requests.UpdateBookRequest;
import kemalkeskin.libary.business.responses.BookResponse;
import kemalkeskin.libary.business.responses.ListBookResponse;
import kemalkeskin.libary.core.utılıtıes.BookModel;
import kemalkeskin.libary.dataAccess.abstracts.BookRepository;
import kemalkeskin.libary.entities.concretes.Author;
import kemalkeskin.libary.entities.concretes.Book;
import kemalkeskin.libary.entities.concretes.Publisher;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BookManager implements BookService {
	
	private BookRepository bookRepository;
	private AuthorService authorService;
	private PublisherService publisherService;

	@Override
	public List<ListBookResponse> getAll() {
//		List<Book>books=;
		
		return bookRepository.findAll().stream().map(BookModel::toListBookResponse).collect(Collectors.toList());
	}

	@Override
	public BookResponse getById(int id) {
		Optional<Book>book=bookRepository.findById(id);
		if(book.isPresent()) {
		return BookModel.toBookResponse(book.get());
		}
		return null;
	}

	@Override
	public BookResponse add(CreateBookRequest createBookRequest) {
		
		Book book=new Book();
		book.setName(createBookRequest.getName());
		book.setPrice(createBookRequest.getPrice());
		Author author =authorService.getAuthorId(createBookRequest.getAuthorId());
		if(Objects.nonNull(author)) {
			book.setAuthor(author);
		}
		Publisher publisher=publisherService.giveById(createBookRequest.getPublisherId());
		if(Objects.nonNull(publisher)) {
			book.setPublisher(publisher);
		}
		
		
	return BookModel.toBookResponse(bookRepository.save(book));
	}

	@Override
	public BookResponse Update(UpdateBookRequest updateBookRequest, int id) {
		Optional<Book>bookList=bookRepository.findById(id);
		if(bookList.isPresent()) {
			Book book2=bookList.get();
			book2.setName(updateBookRequest.getName());
			book2.setPrice(updateBookRequest.getPrice());
			
		return BookModel.toBookResponse(bookRepository.save(book2));
		}
	
		return null;
	}

	@Override
	public void delete(int id) {
		this.bookRepository.deleteById(id);
		
	}
	
	
	
	

}
