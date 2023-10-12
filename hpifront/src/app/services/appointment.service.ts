import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './healper';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  id = '';
  constructor(private http: HttpClient) { }
  public addappointment(appointment: any) {
    console.log(appointment);
    return this.http.post(`${baseUrl}/api/v1/appointments`, appointment)
  }
  public getStarttime(appointment: any) {
    console.log(appointment);
    return this.http.post(`${baseUrl}/api/v1/appointments/GetStartdate`, appointment)
  }

  public getAppointmentId() {
    return this.id;

  }

  public setAppointmentId(id: any) {
    this.id = id;
  }

}
