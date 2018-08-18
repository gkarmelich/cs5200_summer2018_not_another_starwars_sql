package edu.northeastern.cs5200.objects;


import javax.persistence.Entity;

@Entity
public class Buy extends Trade {
	private int unitsPurchased; 
	private double unitPurchasePrice;
	
	public Buy() {
		super();
	}
	
	public Buy(Stock stock, int unitsPurchased, double unitPurchasePrice) {
		super(stock);
		this.unitsPurchased = unitsPurchased;
		this.unitPurchasePrice = unitPurchasePrice;
		
	}

	public int getUnitsPurchased() {
		return unitsPurchased;
	}

	public void setUnitsPurchased(int unitsPurchased) {
		this.unitsPurchased = unitsPurchased;
	}

	public double getUnitPurchasePrice() {
		return unitPurchasePrice;
	}

	public void setUnitPurchasePrice(double unitPurchasePrice) {
		this.unitPurchasePrice = unitPurchasePrice;
	}

	
}
