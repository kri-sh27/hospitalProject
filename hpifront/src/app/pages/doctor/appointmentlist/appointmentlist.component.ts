import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AppointmentService } from 'src/app/services/appointment.service';
import { AppointmentlistService } from 'src/app/services/appointmentlist.service';

@Component({
  selector: 'app-appointmentlist',
  templateUrl: './appointmentlist.component.html',
  styleUrls: ['./appointmentlist.component.css']
})
export class AppointmentlistComponent implements OnInit {

  constructor(private appointmentservice: AppointmentlistService, private ap: AppointmentService) { }
  appointlist: any;
  page:any=1;
  total:any;
  ngOnInit(): void {
    this.getAllAppointments();
  
    

  }
  getAllAppointments() {
    this.appointmentservice.getAllAppointments().subscribe((aptlist) => {
      this.appointlist = aptlist.body;
      this.total=this.appointlist.length
      console.log((this.appointlist));
    })
  }

  setAppointmentId(id: any) {
    this.ap.setAppointmentId(id);

  }
}

