package kemalkeskin.libary.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.libary.entities.concretes.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
