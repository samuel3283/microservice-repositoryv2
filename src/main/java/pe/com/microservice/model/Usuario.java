package pe.com.microservice.model;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Builder;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Usuario {

	private String usuario;
	private String nombre;
	private String email;
	private String password;
	private String tipoDocumento;
	private String numDocumento;
	private String telefono;
	private String fechaRegistro;
	private Integer estado;
	private String perfil;
	
}
