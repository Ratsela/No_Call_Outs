package nocallouts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="problem")
public class Problem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int problem_id;
	private String customer_name;
	private String customer_email;
	private String customer_address;
	private String customer_contact;
	private String description;
	private byte[] image;
	
	public Problem() {
		super();
	}

	public Problem(int id, String customer_name, String customer_email, String customer_address,
			String customer_contact, String description, byte[] image) {
		super();
		this.problem_id = id;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.customer_address = customer_address;
		this.customer_contact = customer_contact;
		this.description = description;
		this.image = image;
	}

	public int getId() {
		return problem_id;
	}

	public void setId(int id) {
		this.problem_id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_contact() {
		return customer_contact;
	}

	public void setCustomer_contact(String customer_contact) {
		this.customer_contact = customer_contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
	
	

}
