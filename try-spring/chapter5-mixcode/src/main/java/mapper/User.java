package mapper;

import java.io.Serializable;

public class User implements Serializable {
	private Integer id;
	private String username;
	private String password;
	private Address address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
		
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", username=" + username + ", password="
				+ password + ", address=" + address + "]";
	}

	public User(Integer id, String username, String password, Address address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public User() {
	}

}
