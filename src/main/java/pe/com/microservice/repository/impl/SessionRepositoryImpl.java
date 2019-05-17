package pe.com.microservice.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.microservice.model.Session;
import pe.com.microservice.repository.SessionRepository;
import pe.com.microservice.repository.mapper.SessionMapper;

@Repository
public class SessionRepositoryImpl implements SessionRepository {

	@Autowired
	@Resource(name = "jdbcTemplateMySql")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Session session) throws Exception {
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("INSERT INTO SESSION ");
		sql_insert_user.append("(TOKEN,USUARIO,NOMBRE,EMAIL,TIPODOC,NUMDOC,TELEFONO,ESTADO, ");
		sql_insert_user.append("PERFIL,FECHAREGISTRO) ");
		sql_insert_user.append("VALUES (?,?,?,?,?,?,?,?,?,?) ");
			
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        
        Object[] params = new Object[] {
        session.getToken(),  session.getUsuario(), session.getNombre(), session.getEmail(), 
        session.getTipoDocumento(), session.getNumDocumento(), session.getTelefono(), 
        session.getEstado(), session.getPerfil(), 
		fechaHora };
		jdbcTemplate.update(sql_insert_user.toString(), params);		
	}

	@Override
	public Session getByToken(String token) throws Exception {
		List <Session> lista = null;
		Session bean = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT TOKEN,USUARIO,NOMBRE,EMAIL,TIPODOC,NUMDOC,TELEFONO,ESTADO, ");
		sql_find_user.append("PERFIL, FECHAREGISTRO ");
  		sql_find_user.append("FROM SESSION WHERE TOKEN = ? ");
		Object[] params = new Object[] {  token  };
    	lista = (List <Session> )jdbcTemplate.query(sql_find_user.toString(),params, new SessionMapper());        	
    	if(lista!=null && lista.size()>0){
    		bean = lista.get(0);
    	}
		return bean;	
	}

}
