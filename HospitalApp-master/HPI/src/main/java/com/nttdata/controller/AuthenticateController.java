package com.nttdata.controller;

import java.security.Principal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.config.JwtUtils;
import com.nttdata.model.JwtRequest;
import com.nttdata.model.JwtResponse;
import com.nttdata.model.User;
import com.nttdata.service.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")

public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	//api name 
	//parameter valiadtion missing done 
	//exception handling done 
	//generate token done
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	    try
	    {
	        authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
	    }
	    catch (Exception e) {
	    	throw new Exception("Invalid username or password"+e.getMessage());
//	        throw new RuntimeException(e);//
	    }   
	    // System.out.println(jwtRequest.getEmail());
	    ////authenticate
	    
	    //exception handlling
	    try {
	    UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	    String token=this.jwtUtils.generateToken(userDetails);
	    return ResponseEntity.ok(new JwtResponse(token));}
	    catch(Exception e) {
	    	throw new Exception("Invalid Username"+e.getMessage());
	    }
	}

	private void authenticate(String username,String password) throws Exception {	
		try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch(DisabledException e)
        {
            throw new Exception("USER DISABLED"+e.getMessage());
        }catch(BadCredentialsException e)
        {
            throw new Exception(" Invalid Credentials"+e.getMessage());
        }
	}
	
//	//return the detilas of current user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal ) {
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
	}
}

