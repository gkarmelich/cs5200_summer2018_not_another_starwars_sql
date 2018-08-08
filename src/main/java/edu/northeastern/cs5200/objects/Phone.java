package edu.northeastern.cs5200.objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPhone;
	private String phone;
	private boolean primary;
	
	public Phone(String phone, boolean primary) {
		this.phone = phone;
		this.primary = primary;
	}
	
	public Phone () {
		
	}

	public int getIdPhone() {
		return idPhone;
	}


	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

}
