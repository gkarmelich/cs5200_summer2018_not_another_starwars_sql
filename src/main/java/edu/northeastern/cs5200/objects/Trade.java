package edu.northeastern.cs5200.objects;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Trade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTrade;
	@ManyToOne
	private Asset asset;
	private double profit;
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	public Trade(Asset asset) {
		this.asset = asset;
	}
	
	public Trade() {
		
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public int getIdTrade() {
		return idTrade;
	}

	public void setIdTrade(int idTrade) {
		this.idTrade = idTrade;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	

}
