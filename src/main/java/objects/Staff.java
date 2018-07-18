package objects;
import java.sql.Date;
import java.util.Collection;

public class Staff extends User {
	private int idStaff;
	private boolean staffAgreement;
	private String staffKey;
	
	public Staff(int idUser, String firstName, String lastName, String userName, String password, String email,
			Date dob, Collection<Phone> phones, Collection<Address> addresses, int idStaff, boolean staffAgreement, String staffKey) {
		super(idUser, firstName, lastName, userName, password, email, dob, phones, addresses);
		this.idStaff = idStaff;
		this.staffAgreement = staffAgreement;
		this.staffKey = staffKey;
	}

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public boolean isStaffAgreement() {
		return staffAgreement;
	}

	public void setStaffAgreement(boolean staffAgreement) {
		this.staffAgreement = staffAgreement;
	}

	public String getStaffKey() {
		return staffKey;
	}

	public void setStaffKey(String staffKey) {
		this.staffKey = staffKey;
	}


}
