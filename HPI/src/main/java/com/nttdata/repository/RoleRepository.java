package com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
