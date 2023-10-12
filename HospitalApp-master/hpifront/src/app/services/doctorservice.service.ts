import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './healper';

@Injectable({
  providedIn: 'root'
})
export class DoctorserviceService {

  constructor(private http: HttpClient) { }
  public getdoctor() {
    return this.http.get(`${baseUrl}/api/v1/appointments/Doctor`)
  }
}
