package edu.northeastern.cs5200.objects;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;


@Entity
public class Investor extends User {
	
	public Investor() {
		super();
	}
	
	public Investor(String firstName, String lastName, String userName, String password, String email,
			Date dob, List<Phone> phones, List<Address> addresses) {
		super(firstName, lastName, userName, password, email, dob, phones, addresses);
	}

}
