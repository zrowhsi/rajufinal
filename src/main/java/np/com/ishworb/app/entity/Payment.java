package np.com.ishworb.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name="paid_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@Enumerated(EnumType.STRING)
	private PaymentMode paidBy;
	@Column(name = "paid_amount")
	private Float paidAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private Customer customer;
	
	
	public Payment() {
	}

	public Payment(Date date, PaymentMode paidBy, Float paidAmount, Customer customer) {
		this.date = date;
		this.paidBy = paidBy;
		this.paidAmount = paidAmount;
		this.customer = customer;
	}







	public Payment(Payment payment) {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public PaymentMode getPaidBy() {
		return paidBy;
	}


	public void setPaidBy(PaymentMode paidBy) {
		this.paidBy = paidBy;
	}


	public Float getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(Float paidAmount) {
		this.paidAmount = paidAmount;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
