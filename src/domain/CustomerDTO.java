package domain;
import lombok.Data;
public @Data class CustomerDTO {
	private String 
			     	no,
				   customerID,
				   customerName,
				   password,
				   ssn,// 900101-1
				   photo,
				   phone,
				   city,
				   address,
				   postalCode
				   ;
}
