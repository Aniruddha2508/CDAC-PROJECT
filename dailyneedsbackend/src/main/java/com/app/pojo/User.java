package com.app.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User extends BaseEntity {
	
	@Column(length = 20,name = "first_name")
	@NotEmpty(message = "name cannot be empty")
	private String firstName;
	
	@Column(length = 20,name = "last_name")
	@NotEmpty(message = "name cannot be empty")
	private String lastName;
	
	@Column(length = 20, name = "contact")
	@Size(min = 10,max = 10)
	private String contact;
	
	@Column(length = 25,unique = true)
	@Email
	@NotEmpty(message = "email cannot be null")
	private String email;

	@Column(length = 100)
	@NotEmpty(message = "password required")
	private String password;
	
	@Column(length = 20)
	@NotEmpty
	private String role;
	
//	@OneToone()
//	@JoinColumn(name="id")
//	List<Cart> cartitems=new ArrayList<>();
//	
//	@OneToMany()
//	@JoinColumn(name="id")
//	List<Product> products=new ArrayList<>();
//	
//	@OneToMany()
//	@JoinColumn(name="id")
//	List<Order>orders=new ArrayList<>();

	


	public User() {
		super();
	}

public User(@NotEmpty(message = "name cannot be empty") String firstName,
		@NotEmpty(message = "name cannot be empty") String lastName, @Size(min = 10, max = 10) String contact,
		@Email @NotEmpty(message = "email cannot be null") String email,
		@NotEmpty(message = "password required") String password, @NotEmpty String role) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.contact = contact;
	this.email = email;
	this.password = password;
	this.role = role;
}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contactNumber) {
		this.contact = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}

}