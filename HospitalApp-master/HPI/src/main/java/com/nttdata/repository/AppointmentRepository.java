package com.nttdata.repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate startDate, LocalDate endDate);
    
//    @Query("select s from appointment s where s.name = :name")
    List<Appointment> findBynameOfDoctor( String name);
    
    List<Appointment> findBypatientname(String name);
    
    @Transactional
    @Modifying
    @Query(value="update appointment set prescription= :prescription,charges= :charges,note= :note where id= :id",nativeQuery = true)
     void AddPrescriptionAndFees(@Param("prescription") String prescription, @Param("charges") double charges, @Param("note") String note,  @Param("id")Long id);
      
    @Query(value="select appointment_start_time from appointment where name_of_doctor = :name and appointment_date = :date",nativeQuery = true)
    List<Time> getStartTime(@Param("name") String name, @Param("date") LocalDate date) ;

    @Transactional
    @Modifying
    @Query(value="update appointment set status= :status where id= :id",nativeQuery = true)
    void payBill(@Param("status") boolean status ,@Param("id") Long id);

}
