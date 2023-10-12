package com.nttdata.model;

import java.util.Collection;



import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "usres")
//
public class User implements UserDetails  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;

	private String password;
	private String fullName;
	private String email;
	private String phone;
	private Date dob;
	private String maritalstatus;
	private String gender;
	private String address;
	private String speciality;

	private boolean enabled = true;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullName=" + fullName
				+ ", email=" + email + ", phone=" + phone + ", dob=" + dob + ", maritalstatus=" + maritalstatus
				+ ", gender=" + gender + ", address=" + address + ", enabled=" + enabled + ", userRoles=" + userRoles
				+ "]";
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public User() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public User(long id, String username, String password, String fullName, String email, String phone, Date dob,
			String maritalstatus, String gender, String address, boolean enabled, Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.maritalstatus = maritalstatus;
		this.gender = gender;
		this.address = address;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> set=new HashSet<>();
		this.userRoles.forEach(userRoles ->{
			set.add(new Authority(userRoles.getRole().getRoleName()));
		});
		
		return set;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getSpeciality() {
		// TODO Auto-generated method stub
		return speciality;
	}
	
	
//	//one patient have many medicine assigned
//	@Exclude
//	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//	private List<MedicineAssigned> medicine;
	
//	//add medicine to the list ie store userid in medicine table
//	public void medicineAssignied(MedicineAssigned medicine) {
//		medicine.setUser(this);
//		medicine.add(medicine);
//	}
	
}
