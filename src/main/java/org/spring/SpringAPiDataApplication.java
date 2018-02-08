package org.spring;






import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SpringAPiDataApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringAPiDataApplication.class, args);
		
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
	
		return builder.sources(SpringAPiDataApplication.class);
	}
}
