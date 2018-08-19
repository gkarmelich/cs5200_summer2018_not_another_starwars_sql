package edu.northeastern.cs5200.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import edu.northeastern.cs5200.daos.StockDao;
import edu.northeastern.cs5200.objects.Stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


public class APIConnector {
	  private String URL = "https://www.alphavantage.co/query?";
	  private String apiKey;
	  private int timeOut;
	  
	  public APIConnector(String apiKey, int timeOut) {
		    this.apiKey = apiKey;
		    this.timeOut = timeOut;
	  }
	  
	  @Autowired
	  StockDao stockDao;
	  
	  
	  public List<Stock> getBatchStockQuotes(List<String> tickerList) throws Exception {
		    try {
			  String tickers = String.join(",", tickerList); 
		      URL request = new URL(URL + "function=BATCH_QUOTES_US&symbols=" + tickers + "&apikey=" + apiKey);
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
		      List<Stock> output = parse(responseBuilder.toString());
		      for (Stock stock : output) {
//		    	  System.out.println(stock.getTicker() + " " + stock.getCurrentUnitValue());
//		    	  System.out.println(stockDao.findAllStock());
		      }
		      return output;
		    } catch (IOException e) {
				throw new Exception("failure sending request", e);
		    }
		  }
	  
	  public StringBuilder getStockQuotes(String ticker) throws Exception {
		    try {
		      URL request = new URL(URL + "function=TIME_SERIES_DAILY&symbol=" + ticker + "&apikey=" + apiKey);
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
//		      System.out.println(responseBuilder);
		      return responseBuilder;
		    } catch (IOException e) {
				throw new Exception("failure sending request", e);
		    }
		  }
	  
	  public List<Stock> parse(String json) {
		  JsonParser parser = new JsonParser();
	      JsonElement jsonElement = parser.parse(json);
	      JsonObject jsonObject =  jsonElement.getAsJsonObject();
	      
	      Type dataType = new TypeToken<List<Map<String, String>>>() {}.getType();
	      
	      Gson GSON = new Gson();
	      List<Map<String, String>> quotes = GSON.fromJson(jsonObject.get("Stock Batch Quotes"), dataType);
	      List<Stock> stocks = new ArrayList<>();
	      quotes.forEach((info) -> stocks.add(new Stock(info.get("1. symbol"), Double.parseDouble(info.get("5. price")))));
	      return stocks;
	  }
	  

}
