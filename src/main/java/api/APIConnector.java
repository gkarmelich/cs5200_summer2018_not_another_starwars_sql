package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class APIConnector {
	  private String URL = "https://www.alphavantage.co/query?";
	  private String apiKey;
	  private int timeOut;
	  
	  public APIConnector(String apiKey, int timeOut) {
		    this.apiKey = apiKey;
		    this.timeOut = timeOut;
	  }
	  
	  
	  public String getRequest(String function, String symbol, int interval) throws Exception {
		    try {
		      URL request = new URL(URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval + "min&apikey=" + apiKey);
		      System.out.println(request.toString());
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
		      System.out.println(responseBuilder.toString());
		      return responseBuilder.toString();
		    } catch (IOException e) {
				throw new Exception("failure sending request", e);
		    }
		  }

}
