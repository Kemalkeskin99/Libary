package kemalkeskin.libary.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "publishers")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisher_Id")
	private int publisherId;
	
	@Column(name = "publisher_Name")
	private String name;
	
	@Column(name = "publisher_Address")
	private String address;
	
	
	@OneToMany(mappedBy = "publisher")
	private List<Book>books;

}
