package np.com.ishworb.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customer")
 @EntityListeners(AuditingEntityListener.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private Long id;
	@NotBlank
	@Column(name = "cust_type")
	private String type;
	@NotBlank
	@Column(name = "cust_name")
	private String name;
	@NotBlank
	@Column(name = "cust_address")
	private String address;
	@NotBlank
	@Column(name = "cust_phone")
	private String phone;
	private Float totalAmount;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer",cascade=CascadeType.ALL)
	private List<CustomerDetails> customerDetails = new ArrayList<CustomerDetails>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer",cascade=CascadeType.ALL)
	private List<Payment> payment = new ArrayList<Payment>();
	

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	

//	public Customer(String type, String name, String address, String phone, Date createdAt, Date updatedAt) {
//		this.type = type;
//		this.name = name;
//		this.address = address;
//		this.phone = phone;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//	}
	


	public Customer(String type, String name, String address, String phone) {
		super();
		this.type = type;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<CustomerDetails> getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(List<CustomerDetails> customerDetails) {
		this.customerDetails = customerDetails;
	}


	public List<Payment> getPayment() {
		return payment;
	}


	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}


	public Float getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}


	

}
