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

import kemalkeskin.libary.business.abstracts.BookService;
import kemalkeskin.libary.business.requests.CreateBookRequest;
import kemalkeskin.libary.business.requests.UpdateBookRequest;
import kemalkeskin.libary.business.responses.BookResponse;
import kemalkeskin.libary.business.responses.ListBookResponse;


@RestController
@RequestMapping("/api/books")


public class BooksController {
	
	private BookService bookService;
	
	
	
	public BooksController(BookService bookService) {
		
		this.bookService = bookService;
	}
	@GetMapping
	public ResponseEntity<List<ListBookResponse>>getAll(){
		
		List<ListBookResponse>bookListBookResponses=bookService.getAll();
		if(bookListBookResponses.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		}
		return new  ResponseEntity<>(bookListBookResponses,HttpStatus.OK);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookResponse>getById(@PathVariable int id){
		
		BookResponse bookResponse =bookService.getById(id);
		if(Objects.isNull(bookResponse)) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<BookResponse>(bookResponse,HttpStatus.OK);
	}
	
	
	
	
	
	
	@PostMapping
	public ResponseEntity<BookResponse>add(@RequestBody CreateBookRequest createBookRequest){
		
		BookResponse bookadd=bookService.add(createBookRequest);
		if(Objects.nonNull(bookadd)) {
			return new ResponseEntity<>(bookadd,HttpStatus.OK);
		}	
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookResponse>update(@RequestParam int id,@RequestBody UpdateBookRequest updateBookRequest){
		BookResponse bookupdate=bookService.Update(updateBookRequest,id);
		if(Objects.isNull(bookupdate)) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<BookResponse>(bookupdate,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@ RequestParam int id) {
		bookService.delete(id);
	}
	
}
