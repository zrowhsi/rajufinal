package np.com.ishworb.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cust_details")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="purchase_date")
	private Date date;
	@Column(name = "item_name")
	private String itemName;
	private int quantity;
	@Column(name = "total_amount")
	private float totalAmount;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id", nullable = false)
	private Customer customer;
	

	public CustomerDetails() {
	}

	public CustomerDetails(Date date, String itemName, int quantity, float totalAmount, Customer customer) {
		this.date = date;
		this.itemName = itemName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.customer = customer;
	}

	public CustomerDetails(Date date, String itemName, int quantity, float totalAmount) {
		this.date = date;
		this.itemName = itemName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public CustomerDetails(CustomerDetails customerDetails) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
