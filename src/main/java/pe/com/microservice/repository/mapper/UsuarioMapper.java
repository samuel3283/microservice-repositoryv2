package pe.com.microservice.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.microservice.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Usuario bean = new Usuario();
		
		try {
			bean.setUsuario(rs.getString(1));
			bean.setNombre(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setTipoDocumento(rs.getString(4));
			bean.setNumDocumento(rs.getString(5));
			bean.setTelefono(rs.getString(6));
			bean.setEstado(rs.getInt(7));
			bean.setPerfil(rs.getString(8));

		} catch (Exception e) {
			e.printStackTrace();
		}				
		return bean;    
          
	}  

}