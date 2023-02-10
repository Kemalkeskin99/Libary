package kemalkeskin.libary.business.responses;




import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class AuthorResponse {
	
	private int authorId;
	private String firstName;
	private String lastName;
	private List<ListBookResponse>listBookResponses;

}
