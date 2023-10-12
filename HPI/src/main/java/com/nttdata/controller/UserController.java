package com.nttdata.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.model.Doctor;
import com.nttdata.model.Role;
import com.nttdata.model.User;
import com.nttdata.model.UserRole;
import com.nttdata.service.DoctorService;
import com.nttdata.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	creating user with role => normal && one Admin role
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) throws Exception {

		System.out.println(user);
		
		//encoding password with bcryptpassword encoder
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles = new HashSet<>();

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		roles.add(userRole);
		//email verification
//		return this.userService.createUser(user, roles);
		return this.userService.createUser(user, roles);
//		if(u==null) {
//			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
//		}
//			return ResponseEntity.of(Optional.of(u));
		
	}
	
	
	
	@PostMapping("/addDoctor")
	public User addDoctor(@RequestBody User user) throws Exception {
		System.out.println(user);
		//encoding password with bcryptpassword encoder
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        
		Set<UserRole> roles = new HashSet<>();

		Role role = new Role();
		role.setRoleId(46L);
		role.setRoleName("DOCTOR");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		roles.add(userRole);
		
		doctorService.addDoctor(new Doctor(user.getUsername(),user.getPassword(),user.getFullName(),user.getPhone(),user.getSpeciality()) );
		
		return this.userService.createUser(user, roles);
		
//		return {"status":HttpStatus.CREATED,"message":,u}
	}
	
	
	
	//  Return Json object throw new 
	// return { "status": 200 , "message" : "User created/ Failed with ", "user": }

//	// get Api Fot getting user by Gmail
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}

//	// delete the user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long uerId) {
		this.userService.deleteUser(uerId);
	}

}
