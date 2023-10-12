import { Component, OnInit } from '@angular/core';
import { AppointmentlistforadminService } from 'src/app/services/appointmentlistforadmin.service';
import { ProfileService } from 'src/app/services/profile/profile.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-appointmentlistforadmin',
  templateUrl: './appointmentlistforadmin.component.html',
  styleUrls: ['./appointmentlistforadmin.component.css']
})
export class AppointmentlistforadminComponent implements OnInit {

  constructor(private ap: AppointmentlistforadminService,private profile:ProfileService) { }
  appointmentlist: any;

  page:any=1;
  total:any;
  ngOnInit(): void {
    this.getAllAppointmentForAdmin();
  }

  status(id: any, status: boolean) {
    // this.profilelist.status=true;
    // console.log(this.profilelist.status);
    this.appointmentlist.id = id;
    this.profile.payBill(this.appointmentlist).subscribe((data) => {
      console.log(data)
      Swal.fire('Payment Done Successfully', 'success');
    },
    (error: any) => {
      console.log("error");
      console.log(error);
      Swal.fire('Invalid Credentials !! try again', 'error');

    });
    // Swal.fire('Payment Done Successfully', 'success');

    console.log(status);
    console.log(id);
  }

  getAllAppointmentForAdmin() {
    this.ap.getAllAppointmentForAdmin().subscribe((res) => {
      console.log(res);
      this.appointmentlist = res;
      this.total=this.appointmentlist.length
    })

  }

}
