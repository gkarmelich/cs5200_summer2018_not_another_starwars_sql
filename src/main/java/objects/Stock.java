package objects;

import java.sql.Date;

public class Stock extends Security {
	private int idStock;
	private String ticker;
	
	public Stock (int idAsset, int unitsPurchased, float unitPurchasePrice, Date datePurchased, int unitsSold, float unitSoldPrice, Date dateSold, int idSecurity, String securityName, int idStock, String ticker) {
		super(idAsset, unitsPurchased, unitPurchasePrice, datePurchased, unitsSold, unitSoldPrice, dateSold, idSecurity, securityName);
		this.idStock = idStock;
		this.ticker = ticker;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}
