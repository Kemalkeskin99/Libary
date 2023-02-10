package kemalkeskin.libary.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.libary.business.abstracts.PublisherService;
import kemalkeskin.libary.business.requests.CreatePublisherRequest;
import kemalkeskin.libary.business.requests.UpdatePublisherRequest;
import kemalkeskin.libary.business.responses.ListPublisherResponse;
import kemalkeskin.libary.business.responses.PublisherResponse;
import kemalkeskin.libary.dataAccess.abstracts.PublisherRepository;
import kemalkeskin.libary.entities.concretes.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor

public class PublisherManager implements PublisherService {
	
	private PublisherRepository publisherRepository;

	@Override
	public List<ListPublisherResponse> getAll() {
		return publisherRepository.findAll().stream().map(this::toListPublisherResponse).collect(Collectors.toList());
	
	}

	@Override
	public PublisherResponse getById(int id) {
	Optional<Publisher>getBY=publisherRepository.findById(id);
	if(getBY.isPresent()) {
		return toPublisherResponse(getBY.get());
	}
	return null;
	}

	@Override
	public PublisherResponse add(CreatePublisherRequest createPublisherRequest) {
		Publisher publisher=new Publisher();
		publisher.setName(createPublisherRequest.getName());
		publisher.setAddress(createPublisherRequest.getAddress());
		return toPublisherResponse(publisherRepository.save(publisher));
	}

	@Override
	public PublisherResponse update(int id,UpdatePublisherRequest updatePublisherRequest) {
		Optional<Publisher> publisher2=publisherRepository.findById(id);
		if(publisher2.isPresent()) {
			Publisher updatePublisher1=publisher2.get();
			updatePublisher1.setName(updatePublisherRequest.getName());
			updatePublisher1.setAddress(updatePublisherRequest.getAddress());
			return toPublisherResponse(publisherRepository.save(updatePublisher1));
		}
		return null;
	}

	@Override
	public void delete(int id) {
		publisherRepository.deleteById(id);
		
	}
	
	
	
	public ListPublisherResponse toListPublisherResponse(Publisher publisher) {
		ListPublisherResponse listPublisherResponse=new ListPublisherResponse();
		listPublisherResponse.setPublisherId(publisher.getPublisherId());
		listPublisherResponse.setName(publisher.getName());
		listPublisherResponse.setAddress(publisher.getAddress());
		
//		List<ListBookResponse>listBookResponses=new ArrayList<>();
		
//		if(publisher.getBooks() !=null) {
//			
//			List<Book>books=publisher.getBooks();
//			
//			for (Book book : books) {
//				
//				ListBookResponse listBookResponse=BookModel.toListBookResponse(book);
//				listBookResponses.add(listBookResponse);
//				
//			}
//		}
//		listPublisherResponse.setListbook(listBookResponses);
		return listPublisherResponse;
		
	}

	
	public PublisherResponse toPublisherResponse(Publisher publisher) {
		PublisherResponse publisherResponse=new PublisherResponse();
		
		publisherResponse.setPublisherId(publisher.getPublisherId());
		publisherResponse.setName(publisher.getName());
		publisherResponse.setAddress(publisher.getAddress());
		return publisherResponse;
		
	}
	
	public Publisher giveById(int id) {
		return publisherRepository.findById(id).orElse(null);
	}
}
