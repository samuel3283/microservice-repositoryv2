package pe.com.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuppressWarnings("unused")
@NoArgsConstructor
//@AllArgsConstructor
public class HeaderRq {

	private String token;
	private String deviceType;
	private String device;
	private String codigo;

	@java.beans.ConstructorProperties({"token", "deviceType", "device", "codigo"})
	public HeaderRq(String token, String deviceType, String device, String codigo) {
	    this.token = token;
	    this.deviceType = deviceType;
	    this.device = device;
	    this.codigo = codigo;
	}


}
