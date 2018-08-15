package edu.northeastern.cs5200.objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPhone;
	private String phone;
	private boolean primaryPhone;
	
	public Phone(String phone, boolean primaryPhone) {
		this.phone = phone;
		this.primaryPhone = primaryPhone;
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
		return primaryPhone;
	}

	public void setPrimary(boolean primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

}
