
public class Transaction {
	private String idx;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private String note;


	public String getIdx() {
		return idx;
	}


	public void setIdx(String idx) {
		this.idx = idx;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "Transaction [idx=" + idx + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender="
				+ gender + ", note=" + note + "]";
	}


	
	
}
