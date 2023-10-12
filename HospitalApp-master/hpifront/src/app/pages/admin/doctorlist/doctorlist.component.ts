import { Component, OnInit } from '@angular/core';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doctorlist',
  templateUrl: './doctorlist.component.html',
  styleUrls: ['./doctorlist.component.css']
})
export class DoctorlistComponent implements OnInit {
 

  // totalRecords:Number | undefined;
  page:any=1;
  total:any;


  constructor(private ds: DoctorService) { }
  doctorlist: any[] = []
  ngOnInit(): void {
    this.getAllDoctors();
  }
  getAllDoctors() {
    this.ds.getAllDoctors()
      .subscribe(res => {
        this.doctorlist = res;
        this.total=this.doctorlist.length

        console.log(res);
        console.log(this.doctorlist)
        console.log(this.total)
      })
  }

}
