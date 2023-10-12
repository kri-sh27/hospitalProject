import { Component, OnInit } from '@angular/core';
import { ProfileService } from 'src/app/services/profile/profile.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private profile: ProfileService) { }

  public userprofile = {
    "id": "",
    "patientname": "",
    "nameOfDoctor": "",
    "appointmentDate": "",
    "appointmentStartTime": "",
    "appointmentEndTime": "",
    "prescription": "",
    "charges": "",
    status: false
  }
  profilelist: any;
  page:any=1;
  total:any;
  ngOnInit(): void {
    this.findByPatientName();
  }

  status(id: any, status: boolean) {
    // this.profilelist.status=true;
    // console.log(this.profilelist.status);
    this.userprofile.id = id;
    this.profile.payBill(this.userprofile).subscribe((data) => {
      console.log(data)
      Swal.fire('Payment Done Successfully', 'success');
    });
    // Swal.fire('Payment Done Successfully', 'success');
    // console.log(status);
    // console.log(id);
  }

  findByPatientName() {
    this.profile.findByPatientName().subscribe((data) => {
      console.log(data);
      this.profilelist = data;
      this.total=this.profilelist.length

      // this.profilelist=data.body;
      console.log(this.profilelist);


    });
  }
}

