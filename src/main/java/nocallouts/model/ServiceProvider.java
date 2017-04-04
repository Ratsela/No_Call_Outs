package nocallouts.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="serviceprovider")
public class ServiceProvider {
	
	private String fname;
	private String lname;
	@Id
	private String email;
	private String contact;
	private String address;
	private String role;
	private String service_description;
	private String services;
	private String password;
	private byte[] profile_pic;
	
	public ServiceProvider() {
		super();
	}

	public ServiceProvider(String fname, String lname, String email, String contact, String address, String role,
			String service_description, String services,String password,byte[] profile_pic) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.role = role;
		this.service_description = service_description;
		this.services = services;
		this.password = password;
		this.profile_pic = profile_pic;
	}
	
	

	public byte[] getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(byte[] profile_pic) {
		this.profile_pic = profile_pic;
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

	public String getService_description() {
		return service_description;
	}

	public void setService_description(String service_description) {
		this.service_description = service_description;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
