package com.nttdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nttdata.model.Appointment;
import com.nttdata.repository.AppointmentRepository;
import com.nttdata.service.AppointmentService;

import java.time.LocalDate;
import java.util.*;

@Component("appointmentService")
@Service
public class AppointmentServiceImplementation implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImplementation() {
    }

    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> findById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate) {
        return appointmentRepository.findAllByAppointmentDateBetweenOrderByPriceAsc(startDate, endDate);
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment appointment) {
        
    
    	return appointmentRepository.save(appointment);
    }
    


//    @Override
//    public Appointment updateStatus(Long appointmentId, Appointment appointment) {
//
//     Optional<Appointment> appointmentList = appointmentRepository.findById(appointmentId);
//
//      if(appointmentList.isPresent()){
//     if(appointment.getStatus() != null){
//         appointmentList.get().setStatus(appointment.getStatus());
//         }
//         return appointmentRepository.save(appointmentList.get());
//     }
//     return null;
// }

   @Override
   public void deleteById(Long appointmentId) {
       appointmentRepository.deleteById(appointmentId);
    }

@Override
public Appointment updateStatus(Long appointmentId, Appointment appointment) {
	// TODO Auto-generated method stub
	return null;
}
}
