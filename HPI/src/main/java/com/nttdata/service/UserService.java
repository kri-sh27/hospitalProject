package com.nttdata.service;

import java.util.Set;


import org.springframework.stereotype.Service;

import com.nttdata.model.User;
import com.nttdata.model.UserRole;

@Service
public interface UserService {

	//create user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    
    //get user by username
    public User getUser(String username);
    
    public void deleteUser(Long userId);
}
