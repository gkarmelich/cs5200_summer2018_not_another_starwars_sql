package edu.northeastern.cs5200.objects;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Security extends Asset {
	private String securityName;
	// current units (total bought - total sold)
	private int unitsHeld;
	// real-time value of security grabbed from API
	private double currentUnitValue;
	
	public Security () {
		super();
	}
	
	public Security (int unitsPurchased, double unitPurchasePrice, Date datePurchased, int unitsSold, double unitSoldPrice, Date dateSold, String securityName, int unitsHeld, double currentUnitValue) {
		super(unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold);
		this.securityName = securityName;
		this.unitsHeld = unitsHeld;
		this.currentUnitValue = currentUnitValue;
	}
	
	public Security(double currentUnitValue) {
		this.currentUnitValue = currentUnitValue;
	}

	public int getUnitsHeld() {
		return unitsHeld;
	}

	public void setUnitsHeld(int unitsHeld) {
		this.unitsHeld = unitsHeld;
	}

	public double getCurrentUnitValue() {
		return currentUnitValue;
	}

	public void setCurrentUnitValue(double currentUnitValue) {
		this.currentUnitValue = currentUnitValue;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	

}
