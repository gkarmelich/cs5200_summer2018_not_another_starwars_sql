package edu.northeastern.cs5200.objects;
import java.util.Collection;

import javax.persistence.Entity;

//@Entity
public class Portfolio {
	private int idPortfolio;
	private Collection<Asset> assets;
	
	public Portfolio(int idPortfolio, Collection<Asset> assets) {
		this.idPortfolio = idPortfolio;
		this.assets = assets;
	}

	public int getIdPortfolio() {
		return idPortfolio;
	}

	public void setIdPortfolio(int idPortfolio) {
		this.idPortfolio = idPortfolio;
	}

	public Collection<Asset> getAssets() {
		return assets;
	}

	public void setAssets(Collection<Asset> assets) {
		this.assets = assets;
	}
	
	

}
