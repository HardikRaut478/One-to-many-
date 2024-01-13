package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class USER {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String role;
	
//	@OneToMany(mappedBy = "user")
//	@JsonBackReference
//	private List<VEHICLE> listOfVehical;.
	
//	public List<VEHICLE> getListOfVehical() {
//		return listOfVehical;
//	}
//	public void addVehical(VEHICLE vehical) {
//		this.listOfVehical.add(vehical);
//	}
//	public void removeVehical(VEHICLE vehical) {
//		this.listOfVehical.remove(vehical);
//	}
	@Override
	public String toString() {
		return "USER [id=" + id + ", Name=" + name + ", password=" + password + ", role=" + role
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
