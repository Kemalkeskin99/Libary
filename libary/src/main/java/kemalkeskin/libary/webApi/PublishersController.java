package kemalkeskin.libary.webApi;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import kemalkeskin.libary.business.abstracts.PublisherService;
import kemalkeskin.libary.business.requests.CreatePublisherRequest;
import kemalkeskin.libary.business.requests.UpdatePublisherRequest;
import kemalkeskin.libary.business.responses.ListPublisherResponse;
import kemalkeskin.libary.business.responses.PublisherResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/api/publishers")
@Data
@AllArgsConstructor

public class PublishersController {

	private PublisherService publisherService;
	
	@GetMapping
	public ResponseEntity<List<ListPublisherResponse>>getAll(){
		List<ListPublisherResponse>responses=publisherService.getAll();
		if(responses.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return new ResponseEntity<>(responses,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PublisherResponse>getById(@PathVariable int id){
		PublisherResponse publishers=publisherService.getById(id);
		if(Objects.isNull(publishers)) {
			return ResponseEntity.badRequest().build();
			
		}
		return new ResponseEntity<PublisherResponse>(publishers,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PublisherResponse>add(@RequestBody CreatePublisherRequest createPublisherRequest){
		PublisherResponse publishers=publisherService.add(createPublisherRequest);
		if(Objects.isNull(publishers)) {
			return ResponseEntity.noContent().build();
			
		}
		return new ResponseEntity<PublisherResponse>(publishers, HttpStatus.OK);
	}
	
	@DeleteMapping
	public void delete(@RequestParam int id) {
		this.publisherService.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PublisherResponse>update(@RequestParam int id,  @RequestBody UpdatePublisherRequest updatePublisherRequest){
	
	PublisherResponse list=publisherService.update(id, updatePublisherRequest);
	if(Objects.isNull(list)) {
		return ResponseEntity.notFound().build();
	}
	return new ResponseEntity<PublisherResponse>(list, HttpStatus.OK);
}
}
