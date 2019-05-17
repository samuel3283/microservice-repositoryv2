package pe.com.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.microservice.core.exception.BooxException;
import pe.com.microservice.core.util.StringEncrypt;
import pe.com.microservice.model.HeaderRq;
import pe.com.microservice.model.Session;
import pe.com.microservice.model.Usuario;
import pe.com.microservice.repository.SessionRepository;
import pe.com.microservice.repository.UsuarioRepository;
import pe.com.microservice.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	SessionRepository sessionRepository;

	@Override
	public Session login(Usuario usuario, HeaderRq headerRq) throws Exception {
		
		Usuario bean = usuarioRepository.login(usuario);
		
		if(bean==null)
			throw new BooxException("5001","Error Usuario y/o Contraseña inválidos.");
				
		Session session = new Session();
		
		
		session.setUsuario(bean.getUsuario());
		session.setEmail(bean.getEmail());
		session.setNombre(bean.getNombre());
		session.setNumDocumento(bean.getNumDocumento());
		session.setTipoDocumento(bean.getTipoDocumento());
		session.setPerfil(bean.getPerfil());
		session.setTelefono(bean.getTelefono());
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHora = sdf.format(dt);
        
		String cadena = bean.getUsuario().concat("-").concat(fechaHora);
		String token = StringEncrypt.encrypt(cadena);
		session.setToken(token);
		sessionRepository.insert(session);

		Session cuenta = sessionRepository.getByToken(session.getToken());

		if(cuenta==null)
			throw new Exception("Error Cuenta not found");
				 		
		return cuenta;
	}
	
}
