package kemalkeskin.libary.business.abstracts;

import java.util.List;

import kemalkeskin.libary.business.requests.CreatePublisherRequest;
import kemalkeskin.libary.business.requests.UpdatePublisherRequest;
import kemalkeskin.libary.business.responses.ListPublisherResponse;
import kemalkeskin.libary.business.responses.PublisherResponse;
import kemalkeskin.libary.entities.concretes.Publisher;

public interface PublisherService {
	
	List<ListPublisherResponse>getAll();
	
	PublisherResponse getById(int id);
	
	PublisherResponse add(CreatePublisherRequest createPublisherRequest);

	PublisherResponse update(int id,UpdatePublisherRequest updatePublisherRequest);
	
	void delete(int id);
	
	Publisher giveById(int id);
	
	
	
}
