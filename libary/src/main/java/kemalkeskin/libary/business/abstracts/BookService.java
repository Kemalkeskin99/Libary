package kemalkeskin.libary.business.abstracts;

import java.util.List;

import kemalkeskin.libary.business.requests.CreateBookRequest;
import kemalkeskin.libary.business.requests.UpdateBookRequest;
import kemalkeskin.libary.business.responses.BookResponse;
import kemalkeskin.libary.business.responses.ListBookResponse;

public interface BookService {
	
	List<ListBookResponse>getAll();
	BookResponse getById(int id);
	BookResponse add(CreateBookRequest bookRequest);
	BookResponse Update(UpdateBookRequest updateBookRequest,int id);
	void delete(int id);
	

}
