package objects;
import java.sql.Date;

public class Security extends Asset {
	private int idSecurity;
	private String securityName;
	
	public Security (int idAsset, int unitsPurchased, float unitPurchasePrice, Date datePurchased, int unitsSold, float unitSoldPrice, Date dateSold, int idSecurity, String securityName) {
		super(idAsset, unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold);
		this.idSecurity = idSecurity;
		this.securityName = securityName;
	}

	public int getIdSecurity() {
		return idSecurity;
	}

	public void setIdSecurity(int idSecurity) {
		this.idSecurity = idSecurity;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	

}
