package pe.com.microservice.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@ComponentScan("pe.com.microservice.*")
public class MicroserviceRepositorioApplication {
	    
    @Value("${spring.datasource.server}")
    private String server;

    @Value("${spring.datasource.database}")
    private String database;

	@Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    public static void main(String[] args) {
		SpringApplication.run(MicroserviceRepositorioApplication.class, args);
	}

    @Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://"+server+":3306/"+database;
		datasource.setUsername(user);
		datasource.setPassword(password);
		datasource.setUrl(url);
		return datasource;
	}
		
	@Bean
	public JdbcTemplate jdbcTemplateMySql() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		//jdbcTemplate.setDataSource(dataSourceOrcl());
		return jdbcTemplate;
	}
	 

}
