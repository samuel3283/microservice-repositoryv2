package pe.com.microservice.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.microservice.model.Session;

public class SessionMapper implements RowMapper<Session> {

	
	public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
		Session bean = new Session();
		try{			
			bean.setToken(rs.getString(1));
			bean.setUsuario(rs.getString(2));
			bean.setNombre(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setTipoDocumento(rs.getString(5));
			bean.setNumDocumento(rs.getString(6));
			bean.setTelefono(rs.getString(7));
			bean.setEstado(rs.getInt(8));
			bean.setPerfil(rs.getString(9));
		} catch (Exception e) {
			e.printStackTrace();
		}				
          return bean;    
	}


}