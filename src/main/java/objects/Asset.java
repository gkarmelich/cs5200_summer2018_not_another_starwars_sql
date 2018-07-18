package objects;
import java.sql.Date;

public class Asset {
	private int idAsset;
	private int unitsPurchased;
	private float unitPurchasePrice;
	private Date datePurchased;
	private int unitsSold;
	private float unitSoldPrice;
	private Date dateSold;
	
	public Asset(int idAsset, int unitsPurchased, float unitPurchasePrice, Date datePurchased, int unitsSold, float unitSoldPrice, Date dateSold) {
		super();
		this.idAsset = idAsset;
		this.unitsPurchased = unitsPurchased;
		this.unitPurchasePrice = unitPurchasePrice;
		this.datePurchased = datePurchased;
		this.unitsSold = unitsSold;
		this.unitSoldPrice = unitSoldPrice;
		this.dateSold = dateSold;
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

	public float getUnitPurchasePrice() {
		return unitPurchasePrice;
	}

	public void setUnitPurchasePrice(float unitPurchasePrice) {
		this.unitPurchasePrice = unitPurchasePrice;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

	public float getUnitSoldPrice() {
		return unitSoldPrice;
	}

	public void setUnitSoldPrice(float unitSoldPrice) {
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
