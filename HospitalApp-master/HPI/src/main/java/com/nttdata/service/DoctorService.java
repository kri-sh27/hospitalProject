package com.nttdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.model.Doctor;
import com.nttdata.repository.DoctorRepository;
@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	
	public Doctor addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
		return doctor;
	}
	
	public List<Doctor> getAllDoctors(){
		List<Doctor> list=doctorRepository.findAll();
		return list;
	}
//	public Doctor getDoctor(String uname) {
//		Doctor d=repo.find
//	}

}
