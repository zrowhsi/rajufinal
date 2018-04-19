package np.com.ishworb.app.entity;

import java.math.BigDecimal;

public class CustomerAmountResult {
	private String name;
	private BigDecimal amountSum;
	private String address;
	private String phone;

	public CustomerAmountResult(String name, BigDecimal amountSum, String address, String phone) {
		this.name = name;
		this.amountSum = amountSum;
		this.address = address;
		this.phone = phone;
	}

	public CustomerAmountResult() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmountSum() {
		return amountSum;
	}

	public void setAmountSum(BigDecimal amountSum) {
		this.amountSum = amountSum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
