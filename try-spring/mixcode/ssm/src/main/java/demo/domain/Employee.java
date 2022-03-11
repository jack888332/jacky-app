package demo.domain;

public class Employee {
	private Integer id;
	private String name;
	private String email;
	private Integer gender;
	private Department department;
	
	public Employee() {
		
	}

	public Employee(Integer id, String name, String email, Integer gender,
			Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email
				+ ", gender=" + gender + ", department=" + department + "]";
	}

}
