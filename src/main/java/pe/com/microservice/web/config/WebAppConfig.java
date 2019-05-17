package pe.com.microservice.web.config;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import pe.com.microservice.web.filter.AccessFilter;
import pe.com.microservice.web.filter.LoggingFilter;




@Configuration
@ComponentScan({ "pe.com.microservice." })
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {


	/**
	 * Método configureContentNegotiation
	 * @param configurer
	 */
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		
		super.configureContentNegotiation(configurer);
		configurer.favorParameter(true);
		/*
		configurer
        .defaultContentType(MediaType.APPLICATION_JSON)
        .favorPathExtension(true);*/
	}
	
	
    /*
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<>();

        resolvers.add(excelViewResolver());

        resolver.setViewResolvers(resolvers);
        return resolver;
    }
*/
	/**
	 * Método configureContentNegotiation
	 * @return filterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterEncodingFilter);
		return registrationBean;
	}

	
	/**
	@Bean
	public Filter compressingFilter() {
		return new CompressingFilter();
	}
	*/
	
	/**
	 * Método accessFilterRegistration
	 * @return FilterRegistrationBean
	 * registration.addInitParameter("appKey", "taxiboox");
	 */
	@Bean
	public FilterRegistrationBean accessFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(accessFilter());
		registration.addInitParameter("appKey", "booxagency");
		registration.addUrlPatterns("/rest/*");
		registration.setName("accessFilter");
		return registration;
	}

	/**
	 * Método accessFilter
	 * @return SecurityAccessFilter
	 */
	@Bean(name = "accessfilter")
 	public AccessFilter accessFilter() {
		return new AccessFilter();
 
	}
	
	
	@Bean(name = "loggingFilter")
 	public LoggingFilter loggingFilter() { 
		return new LoggingFilter();
	}
	

}
