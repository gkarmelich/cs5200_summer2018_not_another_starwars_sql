package objects;
import java.sql.Date;

public class Cash extends Asset {
	private int idCash;
	private String currencyName;
	
	public Cash(int idAsset, int unitsPurchased, float unitPurchasePrice, Date datePurchased, int unitsSold, float unitSoldPrice, Date dateSold, int idCash, String currencyName) {
		super(idAsset, unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold);
		this.idCash = idCash;
		this.currencyName = currencyName;
	}

	public int getIdCash() {
		return idCash;
	}

	public void setIdCash(int idCash) {
		this.idCash = idCash;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	

}
