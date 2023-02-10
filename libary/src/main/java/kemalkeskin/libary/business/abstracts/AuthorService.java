package kemalkeskin.libary.business.abstracts;

import java.util.List;

import kemalkeskin.libary.business.requests.CreateAuthorRequest;
import kemalkeskin.libary.business.requests.UpdateAuthorRequest;
import kemalkeskin.libary.business.responses.AuthorResponse;
import kemalkeskin.libary.business.responses.ListAuthorResponse;
import kemalkeskin.libary.entities.concretes.Author;


public interface AuthorService {
	List<ListAuthorResponse>getAll();
	AuthorResponse getById(int id);
	AuthorResponse add(CreateAuthorRequest createAuthorRequest);
	AuthorResponse Update(UpdateAuthorRequest updateAuthorRequest,int id);
	void delete(int id);
	ListAuthorResponse listAuthorResponse(Author author);
	AuthorResponse authorResponses(Author author);
	Author getAuthorId(int id);

}
