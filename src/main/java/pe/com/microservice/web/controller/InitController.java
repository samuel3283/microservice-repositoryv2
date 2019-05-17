package pe.com.microservice.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

	 @RequestMapping(value ="/", 
				method = RequestMethod.GET )
			 @ResponseBody
			 String home() {
			 return "Microservice v1.0";
	 }
	 
}
