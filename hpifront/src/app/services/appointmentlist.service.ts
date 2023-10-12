import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './healper';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AppointmentlistService {

  constructor(private http: HttpClient, private login: LoginService) { }
  username = this.login.getUser().fullName;


  //get appointment details by patientname
  getAllAppointments() {
    console.log(this.username);
    return this.http.get<any>(`${baseUrl}/api/v1/appointments/getappointbyid/` + this.username, {
      observe: 'response'
    })
  }
}
