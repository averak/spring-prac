package spring.tutorial.model;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class UserModel {
	@Id
	private String userId;
	private String password;
	private String firstName;
	private String lastName;

	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RoleName getRoleName() {
		return this.roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
}
