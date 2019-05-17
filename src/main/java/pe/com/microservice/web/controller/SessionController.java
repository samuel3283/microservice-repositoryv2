package pe.com.microservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.microservice.service.SessionService;
import pe.com.microservice.core.util.HeaderRqUtil;
import pe.com.microservice.model.HeaderRq;
import pe.com.microservice.model.Usuario;
import pe.com.microservice.model.Session;
import pe.com.microservice.model.TransactionRs;

@RestController
@RequestMapping("/rest")
public class SessionController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private HeaderRqUtil headerRqUtil;
	

	@RequestMapping(value ="/service/session/login", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Session> login(
			@RequestHeader HttpHeaders headers, @RequestBody Usuario request) {
		
		TransactionRs<Session> response = new TransactionRs<Session>();			
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			response.setRespuesta(sessionService.login(request,headerRq));				
		} catch (Exception e) {
			response.setCodigoError("5000");
			response.setDescripcion(e.getMessage());
		}
		
		return response;
	}
	
	
}
