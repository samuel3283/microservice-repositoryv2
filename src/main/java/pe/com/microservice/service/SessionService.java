package pe.com.microservice.service;

import pe.com.microservice.model.HeaderRq;
import pe.com.microservice.model.Session;
import pe.com.microservice.model.Usuario;

public interface SessionService {

	Session login(Usuario usuario, HeaderRq headerRq) throws Exception;
	
}
