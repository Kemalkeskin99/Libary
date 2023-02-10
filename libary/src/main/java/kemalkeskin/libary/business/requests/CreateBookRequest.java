package kemalkeskin.libary.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CreateBookRequest {
	
	private int authorId;
	private int publisherId;
	private String name;
	private double price;
	
	

}
