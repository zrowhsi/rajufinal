package np.com.ishworb.app.entity;

public enum PaymentMode {
	CASH, CHEQUE;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
