package edu.northeastern.cs5200;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import edu.northeastern.cs5200.api.APIConnector;


@SpringBootApplication
public class Cs5200ProjectApplication extends SpringBootServletInitializer {
	


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cs5200ProjectApplication.class);
	}
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Cs5200ProjectApplication.class, args);
		
		
		APIConnector request = new APIConnector("LRYEV4NT70I96TDA", 2000);
		List<String> tickers = new ArrayList<>();
		tickers.add("MSFT");
		tickers.add("TWTR");
		
		// Create runnable so that API call is executed on a schedule
		// FYI, the API limits calls to 5 requests per minute
		
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					request.getStockQuotes("BATCH_QUOTES_US", tickers);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		// Call API every minute for real time stock quotes
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(runnable, 0, 60, TimeUnit.SECONDS);
	}
	
}
