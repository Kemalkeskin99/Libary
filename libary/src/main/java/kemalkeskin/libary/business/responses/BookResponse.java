package kemalkeskin.libary.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookResponse {
	
	private int id;
	private String name;
	private double price;
	private int authorId;
	private int publisherId;
	
	

}
