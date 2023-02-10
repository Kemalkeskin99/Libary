package kemalkeskin.libary.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.libary.entities.concretes.Publisher;

public interface PublisherRepository  extends  JpaRepository<Publisher, Integer>{

}
