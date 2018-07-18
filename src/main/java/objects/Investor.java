package objects;
import java.sql.Date;
import java.util.Collection;

public class Investor extends User {
	private int idInvestor;
	private boolean investorAgreement;
	private String investorKey;
	
	public Investor(int idUser, String firstName, String lastName, String userName, String password, String email,
			Date dob, Collection<Phone> phones, Collection<Address> addresses, int idInvestor, boolean investorAgreement, String investorKey) {
		super(idUser, firstName, lastName, userName, password, email, dob, phones, addresses);
		this.idInvestor = idInvestor;
		this.investorAgreement = investorAgreement;
		this.investorKey = investorKey;
	}

	public int getIdInvestor() {
		return idInvestor;
	}

	public void setIdInvestor(int idInvestor) {
		this.idInvestor = idInvestor;
	}

	public boolean isInvestorAgreement() {
		return investorAgreement;
	}

	public void setInvestorAgreement(boolean investorAgreement) {
		this.investorAgreement = investorAgreement;
	}

	public String getInvestorKey() {
		return investorKey;
	}

	public void setInvestorKey(String investorKey) {
		this.investorKey = investorKey;
	}

}
