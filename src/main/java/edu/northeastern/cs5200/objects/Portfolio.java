package edu.northeastern.cs5200.objects;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Portfolio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPortfolio;
	
	@OneToOne
	private Investor investor;
	@OneToOne
	private Manager manager;
	@ManyToMany
	private List<Staff> staff;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Asset> assets;
	
	public Portfolio(List<Asset> assets, Investor investor, Manager manager, List<Staff> staff) {
		this.assets = assets;
		this.investor = investor;
		this.manager = manager;
		this.staff = staff;
	}
	
	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public Portfolio() {
		
	}

	public int getIdPortfolio() {
		return idPortfolio;
	}

	public void setIdPortfolio(int idPortfolio) {
		this.idPortfolio = idPortfolio;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
	
	

}
