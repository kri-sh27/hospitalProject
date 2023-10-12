import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './healper';

@Injectable({
  providedIn: 'root'
})
export class AppointmentlistforadminService {

  constructor(private http: HttpClient) { }

  getAllAppointmentForAdmin() {
    return this.http.get<any>(`${baseUrl}/api/v1/appointments/`)
  }
}
