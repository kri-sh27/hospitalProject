import { Component, OnInit } from '@angular/core';
import { AppointmentService } from 'src/app/services/appointment.service';
import { DoctorService } from 'src/app/services/doctor.service';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  constructor(private appointmentservice: AppointmentService, private ds: DoctorService, private login: LoginService) { }

  public appointment = {
    "patientname": this.login.getUser().fullName,
    "id": this.login.getUser().id,
    "createdAt": '',
    "appointmentDate": '',
    "appointmentStartTime": '00:00:00',
    "appointmentEndTime": '00:00:00',
    "nameOfDoctor": '',
    "status": '',
    "speciality": '',
    "healthIssue": ''
  }
  starttime1: any[] = ["9:00:00", "9:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00",
    "13:00:00", "13:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00", "17:00:00", "17:30:00",
    "18:00:00", "18:30:00"];

  endtime: any[] = ["9:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00",
    "13:00:00", "13:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00", "17:00:00", "17:30:00",
    "18:00:00", "18:30:00", "19:00:00"];
  starttime: any[] = []
  list: any[] = []
  ngOnInit(): void {
    this.getdoctor();
    console.log(this.appointment.patientname)
  }
  list1: any[] = []

  getspeciality() {
    for (let i = 0; i < this.list.length; i++) {
      if (this.list[i].fullName == this.appointment.nameOfDoctor)
        this.appointment.speciality = this.list[i].speciality.toString();
    }
  }
  getStarttime() {
    // this.appointment.appointmentDate.split("-").reverse().join("-");
    console.log(this.appointment)
    this.appointmentservice.getStarttime(this.appointment).subscribe(
      (data: any) => {
        this.list1 = data
        console.log(this.list1);
        this.filtertime();
        //success
        // console.log(this.appointment.id);
        // console.log(data);
        // alert("sucess");
        // Swal.fire('Booked Successfully','success');
      }
    )

  }
  filtertime() {
    let isFound = false;
    for (let i = 0; i < this.starttime1.length; i++) {
      for (let j = 0; j < this.list1.length; j++) {
        if (this.starttime1[i] == this.list1[j]) {
          isFound = true;
        }
      }
      if (isFound == false) {
        this.starttime.unshift(this.starttime1[i])
      }
      isFound = false;
    }
    console.log(this.starttime)
  }
  getendtime() {
    for (let i = 0; i < this.starttime.length; i++) {
      if (this.starttime[i] == this.appointment.appointmentStartTime) {
        console.log(this.appointment.appointmentStartTime)
        let j = this.endtime.indexOf(this.starttime[i])
        this.appointment.appointmentEndTime = this.endtime[j + 1];
      }
      // this.appointment.appointmentEndTime=this.endtime[i];
    }
    console.log(this.appointment.appointmentStartTime)
    console.log(this.appointment.appointmentEndTime)
    console.log("method called")
  }
  getdoctor() {
    this.ds.getdoctor().subscribe((data: any) => {
      this.list = data
      console.log(this.list);
    }
    );

  }

  formSubmit() {
    // alert('submit')
    console.log(this.appointment);
    if (this.appointment.id == null) {
      // alert('User is requirsd');
      Swal.fire('id is Requird', 'info');
      return;
    }
    else if (this.appointment.appointmentDate == '' || this.appointment.appointmentDate == null) {
      // alert('Email is requird');
      Swal.fire('Date is required', 'info');
      return;
    }
    //addUser:userservices
    this.appointmentservice.addappointment(this.appointment).subscribe(
      (data: any) => {
        //success
        console.log(this.appointment.id);
        console.log(data);
        console.log(this.appointment)
        // alert("sucess");
        Swal.fire('Booked Successfully', 'success');
      },
      (error) => {
        //error
        console.log(error);
        // alert("something went wrong");
        Swal.fire('something went wrong', 'error');
      }
    )
  }
}
