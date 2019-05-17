package pe.com.microservice.repository;

import pe.com.microservice.model.Session;

public interface SessionRepository {

	public void insert(Session session) throws Exception;
	public Session getByToken(String token) throws Exception;
	
}
