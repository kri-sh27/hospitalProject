package com.nttdata.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.model.Doctor;
import com.nttdata.model.Role;
import com.nttdata.service.DoctorService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class DoctorController {
	
	
	
		@Autowired
		DoctorService doctorService;
		@RolesAllowed("ADMIN")
		@PostMapping(value="/createdoctor" ,  consumes= { "application/json"})
		public Doctor addDoctor(@RequestBody Doctor doctor)throws Exception {

//				System.out.println(doctor);
//				Doctor d=new Doctor("deepak","1234","deepak bhai","123456","Psychiatry","9am-12pm");
				
//			Role role1=new Role();
//			role1.setRoleId(46L);//46
//			role1.setRoleName("DOCTOR");
				return doctorService.addDoctor(doctor);
			
		}
		
		
		
		
		
		@RolesAllowed("ADMIN")
		@GetMapping("/getalldoctors")
		public List<Doctor> get() {
			return doctorService.getAllDoctors();
		}

}

