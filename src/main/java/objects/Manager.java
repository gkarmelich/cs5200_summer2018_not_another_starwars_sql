package objects;
import java.sql.Date;
import java.util.Collection;

public class Manager extends User {
	private int idManager;
	private boolean managerAgreement;
	private String managerKey;
	
	public Manager(int idUser, String firstName, String lastName, String userName, String password, String email,
			Date dob, Collection<Phone> phones, Collection<Address> addresses, int idManager, boolean managerAgreement, String managerKey) {
		super(idUser, firstName, lastName, userName, password, email, dob, phones, addresses);
		this.idManager = idManager;
		this.managerAgreement = managerAgreement;
		this.managerKey = managerKey;
	}

	public int getIdManager() {
		return idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	public boolean isManagerAgreement() {
		return managerAgreement;
	}

	public void setManagerAgreement(boolean managerAgreement) {
		this.managerAgreement = managerAgreement;
	}

	public String getManagerKey() {
		return managerKey;
	}

	public void setManagerKey(String managerKey) {
		this.managerKey = managerKey;
	}

	

}
