package kemalkeskin.libary.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.libary.entities.concretes.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
