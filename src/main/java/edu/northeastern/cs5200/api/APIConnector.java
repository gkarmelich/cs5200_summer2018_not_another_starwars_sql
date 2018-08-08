package edu.northeastern.cs5200.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


public class APIConnector {
	  private String URL = "https://www.alphavantage.co/query?";
	  private String apiKey;
	  private int timeOut;
	  
	  public APIConnector(String apiKey, int timeOut) {
		    this.apiKey = apiKey;
		    this.timeOut = timeOut;
	  }
	  
	  
	  public StringBuilder getStockQuotes(String function, List<String> tickerList) throws Exception {
		    try {
		      String tickers = String.join(",", tickerList);
		      URL request = new URL(URL + "function=" + function + "&symbols=" + tickers + "&apikey=" + apiKey);
		      URLConnection connection = request.openConnection();
		      connection.setConnectTimeout(timeOut);
		      connection.setReadTimeout(timeOut);

		      InputStreamReader inputStream = new InputStreamReader(connection.getInputStream(), "UTF-8");
		      BufferedReader bufferedReader = new BufferedReader(inputStream);
		      StringBuilder responseBuilder = new StringBuilder();

		      String line;
		      while ((line = bufferedReader.readLine()) != null) {
		        responseBuilder.append(line);
		      }
		      bufferedReader.close();
		      System.out.println(responseBuilder);
		      return responseBuilder;
		    } catch (IOException e) {
				throw new Exception("failure sending request", e);
		    }
		  }
	  

}
