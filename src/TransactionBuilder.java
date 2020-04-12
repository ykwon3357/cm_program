
public class TransactionBuilder {
	private Transaction t;
	
	public TransactionBuilder(Transaction t) {
		this.t=t;
	}
	public TransactionBuilder idx(String idx) {
		t.setIdx(idx);
		return this;
	}
	public TransactionBuilder name(String name) {
		t.setName(name);
		return this;
	}
	public TransactionBuilder email(String email) {
		t.setEmail(email);
		return this;
	}
	public TransactionBuilder phone(String phone) {
		t.setPhone(phone);
		return this;
	}
	public TransactionBuilder gender(String gender) {
		t.setGender(gender);
		return this;
	}
	public TransactionBuilder note(String note) {
		t.setNote(note);
		return this;
	}
	public Transaction transaction() {
		return t;
	}
}
