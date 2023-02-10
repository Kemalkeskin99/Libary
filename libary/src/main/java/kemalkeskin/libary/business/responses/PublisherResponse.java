package kemalkeskin.libary.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublisherResponse {
	
	private int publisherId;
	

	private String name;
	

	private String address;

}
