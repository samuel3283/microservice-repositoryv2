package pe.com.microservice.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.microservice.model.Usuario;
import pe.com.microservice.repository.UsuarioRepository;
import pe.com.microservice.repository.mapper.UsuarioMapper;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

	@Autowired
	@Resource(name = "jdbcTemplateMySql")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario get(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> list(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario login(Usuario usuario) throws Exception {
		List <Usuario> lista = null;
		Usuario bean = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT u.USUARIO, u.NOMBRE, u.EMAIL, u.TIPODOC, u.NUMDOC, u.TELEFONO, ");
		sql_find_user.append("u.ESTADO, u.PERFIL ");
		sql_find_user.append("FROM USUARIO u ");
		sql_find_user.append("WHERE u.USUARIO = ? and u.PASSWORD = ? ");

		Object[] params = new Object[] {  usuario.getUsuario(), usuario.getPassword() };
  		
    	lista = (List <Usuario> )jdbcTemplate.query(sql_find_user.toString(),params, new UsuarioMapper());
    	if(lista!=null && lista.size()>0){
    		bean = lista.get(0);
    	}

		return bean;
	}

}
