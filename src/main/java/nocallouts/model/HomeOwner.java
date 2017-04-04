package nocallouts.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="homeowner")
public class HomeOwner {
	
	private String fname;
	private String lname;
	@Id
	private String email;
	private String contact;
	private String address;
	private String role;
	private String password;
	
	public HomeOwner() {
		super();
	}

	public HomeOwner(String fname, String lname, String email, String contact, String address, String role,String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.role = role;
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
