package main.java.com.godevtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

public class ClientRequest {

	@Autowired
	private RestTemplate restTemplate;
		
	@Configuration
	public class ClientApplicationConfiguration {
	    @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	}
	
	
}
