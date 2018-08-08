package edu.northeastern.cs5200.objects;

import java.sql.Date;
import javax.persistence.Entity;

@Entity
public class Stock extends Security {
	private String ticker;
	
	public Stock() {
		
	}
	
	public Stock (int unitsPurchased, double unitPurchasePrice, Date datePurchased, int unitsSold, double unitSoldPrice, Date dateSold, String securityName, String ticker) {
		super(unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold, securityName);
		this.ticker = ticker;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}
