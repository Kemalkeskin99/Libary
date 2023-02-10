package kemalkeskin.libary.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
 @Data
 @Setter
 @Getter
 @NoArgsConstructor
 @AllArgsConstructor
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_Id")
	private int id;
	
	@Column(name="book_name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne
	private Author author;
	
	@ManyToOne
	private Publisher publisher;

}
