package edu.northeastern.cs5200;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import api.APIConnector;

@SpringBootApplication
public class Cs5200ProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cs5200ProjectApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Cs5200ProjectApplication.class, args);
		
		APIConnector request = new APIConnector("LRYEV4NT70I96TDA", 2000);
		request.getRequest("TIME_SERIES_INTRADAY", "TWTR", 15);
	}
}
