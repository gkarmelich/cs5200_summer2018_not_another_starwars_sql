package edu.northeastern.cs5200.objects;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Security extends Asset {
	private String securityName;
	
	public Security (int unitsPurchased, double unitPurchasePrice, Date datePurchased, int unitsSold, double unitSoldPrice, Date dateSold, String securityName) {
		super(unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold);
		this.securityName = securityName;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	

}
