package com.nttdata.controller;

import org.springframework.web.bind.annotation.CrossOrigin;


import com.nttdata.model.Appointment;
import com.nttdata.model.Doctor;
import com.nttdata.model.PrescriptionAndFees;
import com.nttdata.repository.AppointmentRepository;
import com.nttdata.repository.DoctorRepository;
import com.nttdata.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private DoctorRepository doctorRepository;

    public AppointmentController() {
    }

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

   /** GET request to return specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
    public Optional<Appointment> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }

    /** GET request to return all appointments **/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentService.findAll();
    }
    /** POST request to add new appointments **/
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.create(appointment);
    }

    /** PUT request to update appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        return appointmentService.update(appointmentId, appointment);
    }



    /** DELETE request to delete specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Long appointmentId) {
        appointmentService.deleteById(appointmentId);
    }
    @RequestMapping(path = "/Doctor", method = RequestMethod.GET)
    public List<Doctor> findById() {
    	
        return doctorRepository.findAll();
    }
    
//    getting appointment by doctor name
    @RequestMapping(path = "/getappointbyid/{username}", method = RequestMethod.GET)
    public List<Appointment> findByDoctorId(@PathVariable String username ) {
    	System.out.println("username");
    	System.out.println(username);
        return appointmentRepository.findBynameOfDoctor(username); 
    }
    
    @RequestMapping(path="/addprescriptionandfees",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void AddPrescriptionAndFees(@RequestBody PrescriptionAndFees prescriptionandfees) {
         appointmentRepository.AddPrescriptionAndFees(prescriptionandfees.prescription, prescriptionandfees.charges,prescriptionandfees.note, prescriptionandfees.id);
    }
    
    
    //getting patient info from appointment table by patient name
    @RequestMapping(path = "/getpatientinfoby/{username}", method = RequestMethod.GET)
    public List<Appointment> findByPatientName(@PathVariable String username ) {
    	System.out.println("username");
    	System.out.println(username);
        return appointmentRepository.findBypatientname(username); 
    }
    
    @RequestMapping(path="/paybill",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void payBill(@RequestBody Appointment id) {
         appointmentRepository.payBill(true,id.getId());
//         return "Successfully paid";
    }
    
    @RequestMapping(path = "/GetStartdate", method = RequestMethod.POST)
    public List<Time> getStartdate(@RequestBody Appointment appointment) {
        return appointmentRepository.getStartTime(appointment.getNameOfDoctor(), appointment.getAppointmentDate());
    }
    
    
}
