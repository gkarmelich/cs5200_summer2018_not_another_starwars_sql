package objects;

public class Phone {
	private int idPhone;
	private String phone;
	private boolean primary;
	
	public Phone(int idPhone, String phone, boolean primary) {
		this.idPhone = idPhone;
		this.phone = phone;
		this.primary = primary;
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
