package com.nttdata.model;

import java.util.HashSet;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
@Entity
@Table(name="doctor")
public class Doctor {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String fullName;
	private String phone;
	private String speciality;
//	private int price;
//	private String timing;
	
	
	public Doctor(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public Doctor(String username2, String password2, String fullName2, String phone2, String speciality2) {
		// TODO Auto-generated constructor stub
		
		this.username=username2;
		this.password=password2;
		this.fullName=fullName2;
		this.phone=phone2;
		this.speciality=speciality2;
	}
	
	
}
