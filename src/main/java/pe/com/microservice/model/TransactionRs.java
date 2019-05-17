package pe.com.microservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class TransactionRs<T> {
	@JsonProperty("codRpta")
	private String codigoError = "0000";

	@JsonProperty("desRpta")
	private String descripcion = "Respuesta Exitosa";

	@JsonProperty("detRpta")
	@JsonInclude(Include.NON_NULL)
	private T respuesta;


}