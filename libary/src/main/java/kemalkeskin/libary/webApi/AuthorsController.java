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

import kemalkeskin.libary.business.abstracts.AuthorService;
import kemalkeskin.libary.business.requests.CreateAuthorRequest;
import kemalkeskin.libary.business.requests.UpdateAuthorRequest;
import kemalkeskin.libary.business.responses.AuthorResponse;
import kemalkeskin.libary.business.responses.ListAuthorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/api/authors")
@Data
@AllArgsConstructor

public class AuthorsController {
	
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<ListAuthorResponse>>getAll(){
		
		List<ListAuthorResponse>authorList=authorService.getAll();
		if(authorList.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}
		return new  ResponseEntity<>(authorList,HttpStatus.OK);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuthorResponse>getById(@PathVariable int id){
		
		AuthorResponse author=authorService.getById(id);
		if(Objects.isNull(author)) {
			return ResponseEntity.notFound().build();
			
		}
		return new  ResponseEntity<>(author,HttpStatus.OK);
	
	}
	
	
	
	
	
	
	
	
	@PostMapping
	public ResponseEntity<AuthorResponse>add(@RequestBody CreateAuthorRequest authorRequest){
		
		AuthorResponse authoradd=authorService.add(authorRequest);
		if(Objects.nonNull(authoradd)) {
			
			return new ResponseEntity<AuthorResponse>(authoradd,HttpStatus.OK);
		}	
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AuthorResponse>update(@RequestParam int id,@RequestBody UpdateAuthorRequest updateAuthorRequest){
		AuthorResponse authorupdate=authorService.Update(updateAuthorRequest,id);
		if(Objects.isNull(authorupdate)) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<AuthorResponse>(authorupdate,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@ RequestParam int id) {
		authorService.delete(id);
	}

}
