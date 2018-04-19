package np.com.ishworb.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ItemDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "item_name")
	private String itemName;
	private int quantity;
	@Column(name = "total_amount")
	private float totalAmount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public ItemDetails(String itemName, int quantity, float totalAmount) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	public ItemDetails() {
		// TODO Auto-generated constructor stub
	}

}
