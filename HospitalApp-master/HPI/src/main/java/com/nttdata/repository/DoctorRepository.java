package com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.model.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
//	public Doctor findDoctorByUsername(String username);
	


}
