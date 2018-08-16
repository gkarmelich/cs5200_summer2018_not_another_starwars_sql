package edu.northeastern.cs5200.objects;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Asset {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAsset;
	private int unitsPurchased;
	private double unitPurchasePrice;
	private Date datePurchased;
	private int unitsSold;
	private double unitSoldPrice;
	private Date dateSold;
	
	public Asset(int unitsPurchased, double unitPurchasePrice, Date datePurchased, int unitsSold, double unitSoldPrice, Date dateSold) {
		super();
		this.unitsPurchased = unitsPurchased;
		this.unitPurchasePrice = unitPurchasePrice;
		this.datePurchased = datePurchased;
		this.unitsSold = unitsSold;
		this.unitSoldPrice = unitSoldPrice;
		this.dateSold = dateSold;
	}
	


	public Asset() {
		super();
	}

	public int getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(int idAsset) {
		this.idAsset = idAsset;
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

	public Date getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}

	public Date getDateSold() {
		return dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}
	
		

}
