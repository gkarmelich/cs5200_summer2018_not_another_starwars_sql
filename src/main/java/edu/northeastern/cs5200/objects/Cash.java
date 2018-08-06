package edu.northeastern.cs5200.objects;
import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Cash extends Asset {
	private String currencyName;
	
	public Cash(int unitsPurchased, double unitPurchasePrice, Date datePurchased, int unitsSold, double unitSoldPrice, Date dateSold, String currencyName) {
		super(unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold);
		this.currencyName = currencyName;
	}
	
	public Cash() {
		super();
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	

}
