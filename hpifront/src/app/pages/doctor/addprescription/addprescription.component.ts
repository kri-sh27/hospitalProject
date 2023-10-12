import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AddprescriptionService } from 'src/app/services/addprescription/addprescription.service';
import { AppointmentService } from 'src/app/services/appointment.service';
import { AppointmentlistService } from 'src/app/services/appointmentlist.service';
import { AppointmentlistforadminService } from 'src/app/services/appointmentlistforadmin.service';
import { GetappointmentbyidService } from 'src/app/services/getappointmentbyid/getappointmentbyid.service';
import { LoginService } from 'src/app/services/login.service';
import { ProfileService } from 'src/app/services/profile/profile.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addprescription',
  templateUrl: './addprescription.component.html',
  styleUrls: ['./addprescription.component.css']
})
export class AddprescriptionComponent implements OnInit {

  constructor(private addprescription: AddprescriptionService, private appointmentservice: AppointmentService,private getbyid:GetappointmentbyidService,private router:Router) { }
  
  addprescriptionandfees = {
    "id": this.appointmentservice.getAppointmentId(),
    // "patientname": this.login.getUser().fullName,
    // "name":this.profile.findByPatientName(),
    "prescription": "",
    "charges": "",
    "note":"",
  }

  appointment:any;
  ngOnInit(): void {
    let idfor=this.addprescriptionandfees.id;console.log(idfor);
    this.getappointmentbyid(idfor);
    console.log("called");

  }

// idfor=this.addprescriptionandfees.id;

getappointmentbyid(id:any){
  console.log(id);
  this.getbyid.getappointmentbyid(id).subscribe((data:any)=>{
    this.appointment=data;
    console.log(this.appointment);
    console.log(data)
    this.addprescriptionandfees.prescription=this.appointment.prescription;

    this.addprescriptionandfees.note=this.appointment.note;

    this.addprescriptionandfees.charges=this.appointment.charges;

    console.log(this.addprescriptionandfees);
  });
}

  formSubmit() {
    // alert('submit')
    console.log(this.addprescriptionandfees);
    if (this.addprescriptionandfees.id == null) {
      // alert('User is requirsd');
      Swal.fire('id is Requird', 'info');
      return;
    }
    else if (this.addprescriptionandfees.prescription == '' || this.addprescriptionandfees.prescription == null) {
      // alert('Email is requird');
      Swal.fire('Prescription is required', 'info');
      return;
    }
    //add rescription
    this.addprescription.addprescription(this.addprescriptionandfees).subscribe(
      (data: any) => {
        //success
        console.log(this.addprescriptionandfees.id);
        console.log(data);
        // alert("sucess");
        Swal.fire('presciption added Successfully', 'success');
        this.router.navigate(['/appointmentlist']);

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
