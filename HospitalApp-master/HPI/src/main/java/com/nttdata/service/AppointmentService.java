package com.nttdata.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.nttdata.model.Appointment;

@Service
public interface AppointmentService {

    Optional<Appointment> findById(Long appointmentId);

    List<Appointment> findAll();

    List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate);

    Appointment create(Appointment appointment);

    Appointment update(Long appointmentId, Appointment appointment);

    Appointment updateStatus(Long appointmentId, Appointment appointment);

    void deleteById(Long appointmentId);
    
//    void AddPrescriptionAndFees(String prescription,  double charges, Long id);


}

