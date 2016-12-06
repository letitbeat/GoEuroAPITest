package main.java.com.godevtest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import main.java.com.godevtest.domain.City;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);
	private static final String REQUEST_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public static void main(String args[]){
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			String cityToSearch = args[0];
			
			logger.info("Getting information for " + cityToSearch);
			City[] cities = restTemplate.getForObject(REQUEST_URL + cityToSearch, City[].class);
			  	
			if (cities != null && cities.length > 0) {

				try (FileWriter fileWriter = new FileWriter(
						"target/APIResponse.csv");
						BufferedWriter bufferedWriter = new BufferedWriter(
								fileWriter);
						PrintWriter out = new PrintWriter(bufferedWriter)) {

					for (City city : cities) {
						logger.info("Writing: " + city.toString());
						out.println(city.toString());
					}

				} catch (IOException e) {
					logger.error("ERROR writing API response to file ", e);
				}

			}

		} catch(ArrayIndexOutOfBoundsException e) {
			logger.error("ERROR A city to search must be passed.");					
		}
				
	}
	
	@Configuration
	public class ClientApplicationConfiguration {
	    @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	}
}

