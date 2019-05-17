package pe.com.microservice.repository;

import java.util.List;

import pe.com.microservice.model.Usuario;

public interface UsuarioRepository {

	public void insert(Usuario usuario) throws Exception;
	public Usuario get(Usuario usuario) throws Exception;
	public List<Usuario> list(Usuario usuario) throws Exception;
	public Usuario login(Usuario usuario) throws Exception;
	
}
