package edu.northeastern.cs5200.objects;

import javax.persistence.Entity;

@Entity
public class Sell extends Trade {
	private int unitsSold; 
	private double unitSoldPrice; 
	
	public Sell() {
		super();
	}
	
	public Sell(Asset asset, int unitsSold, double unitSoldPrice) {
		super(asset);
		this.unitsSold = unitsSold;
		this.unitSoldPrice = unitSoldPrice;
		
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

	public double getUnitSoldPrice() {
		return unitSoldPrice;
	}

	public void setUnitSoldPrice(double unitSoldPrice) {
		this.unitSoldPrice = unitSoldPrice;
	}

}
