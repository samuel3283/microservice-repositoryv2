package pe.com.microservice.service;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.microservice.model.HeaderRq;
import pe.com.microservice.model.Session;
import pe.com.microservice.model.Usuario;
import pe.com.microservice.repository.SessionRepository;
import pe.com.microservice.repository.UsuarioRepository;
import pe.com.microservice.service.impl.SessionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SessionServiceTest {

	@InjectMocks
	SessionServiceImpl sessionService = new SessionServiceImpl();
	
	@Mock
	UsuarioRepository usuarioRepository;

	@Mock
	SessionRepository sessionRepository;

	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);	
	}

	@Test
	public void testLogin() throws Exception {

		HeaderRq headerRq = new HeaderRq();
		Mockito.when(usuarioRepository.login(any(Usuario.class))).thenReturn(createUsuario());	
		//Mockito.doNothing().when(sessionRepository).insert(any(Session.class));		
		Mockito.when(sessionRepository.getByToken(any(String.class))).thenReturn(createSession());	
		
		Session response = sessionService.login(createUsuario(), headerRq);
		assertTrue(response.getToken().length() > 0);
		//assertThat(response, is(not(nullValue())));	
		assertTrue(response != null );
			
	}
	
	public Session createSession() {
		Session bean = new Session();
		bean.setToken("JOzQDIhsv4qJ8VepYNPnHPDPcSAzZXgl8zEXolsXjDE=");
		return bean;
	}

	public Usuario createUsuario() {
		Usuario bean = new Usuario();
		bean.setUsuario("user");
		bean.setPassword("admin");
		bean.setNombre("Miguel");
		bean.setEmail("usuario@gmail.com");
		return bean;
	}
	
	
}
