package kemalkeskin.libary.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.libary.business.abstracts.AuthorService;
import kemalkeskin.libary.business.requests.CreateAuthorRequest;
import kemalkeskin.libary.business.requests.UpdateAuthorRequest;
import kemalkeskin.libary.business.responses.AuthorResponse;
import kemalkeskin.libary.business.responses.ListAuthorResponse;
import kemalkeskin.libary.business.responses.ListBookResponse;
import kemalkeskin.libary.core.utılıtıes.BookModel;
import kemalkeskin.libary.dataAccess.abstracts.AuthorRepository;
import kemalkeskin.libary.entities.concretes.Author;
import kemalkeskin.libary.entities.concretes.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
@Service
@Data
@AllArgsConstructor


public class AuthorManager implements AuthorService{
	
	private final AuthorRepository authorRepository;
	


	
	@Override
	public List<ListAuthorResponse> getAll() {
		return authorRepository.findAll().stream().map(this::listAuthorResponse).collect(Collectors.toList());
	}

	@Override
	public AuthorResponse getById(int id) {
		Optional<Author> author=authorRepository.findById(id);
		if(author.isPresent()) {
			return authorResponses(author.get());
		}
		return null;
	}

	@Override
	public AuthorResponse add(CreateAuthorRequest createAuthorRequest) {
		Author author=new Author();
		author.setFirstName(createAuthorRequest.getFirstName());
		author.setLastName(createAuthorRequest.getLastName());
		
	return authorResponses ( authorRepository.save(author));
	
	}

	@Override
	public AuthorResponse Update(UpdateAuthorRequest updateAuthorRequest, int id) {
		Optional<Author>listAuthor=authorRepository.findById(id);
		if(listAuthor.isPresent()) {
			Author authorupdate=listAuthor.get();
			authorupdate.setFirstName(updateAuthorRequest.getFirstName());
			authorupdate.setLastName(updateAuthorRequest.getLastName());
			return authorResponses( authorRepository.save(authorupdate));
		}
		return null;
	}

	@Override
	public void delete(int id) {
	this.authorRepository.deleteById(id);
		
	}
	
	public ListAuthorResponse listAuthorResponse(Author author) {
		ListAuthorResponse listAuthorResponse=new ListAuthorResponse();
		listAuthorResponse.setAuthorId(author.getAuthorId());
		listAuthorResponse.setFirstName(author.getFirstName());
		listAuthorResponse.setLastName(author.getLastName());
		return listAuthorResponse;
	}
	
	public AuthorResponse authorResponses(Author author) {
		AuthorResponse authorResponse=new AuthorResponse();
		authorResponse.setAuthorId(author.getAuthorId());
		authorResponse.setFirstName(author.getFirstName());
		authorResponse.setLastName(author.getLastName());
		
		
		List<ListBookResponse>listBookResponses=new ArrayList<>();
		
		if(author.getBooks() !=null) {
		List<Book>bookList=author.getBooks();
		for (Book book : bookList) {
			
			ListBookResponse listBookResponse=BookModel.toListBookResponse(book);
			listBookResponses.add(listBookResponse);
		}
		//for yerine bunuda yapabılırz.lamda denır bu arada
		//List<ListBookResponse>listBookResponses2=bookList.stream().map(book ->bookService.toListBookResponse(book)).collect(Collectors.toList());
		}
		authorResponse.setListBookResponses(listBookResponses);
		return authorResponse;
	}

	@Override
	public Author getAuthorId(int id) {
		
		return authorRepository.findById(id).orElse(null);
	}

	

	

}

