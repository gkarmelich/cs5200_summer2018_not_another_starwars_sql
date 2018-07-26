package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class APIConnector {
	  private String BASE_URL = "https://www.alphavantage.co/query?";
	  private String apiKey = "LRYEV4NT70I96TDA";
	  private int timeOut = 2000;
	  private String apiParameters;
	  
	  public APIConnector(String apiKey, int timeOut) {
		    this.apiKey = apiKey;
		    this.timeOut = timeOut;
	  }
	  
	  public APIConnector() {
		   
	  }
	  
	  public String getRequest(String apiParameters) throws Exception {
		    String params = apiParameters;
		    try {
		      URL request = new URL(BASE_URL + params);
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
