import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../healper';
import { LoginService } from '../login.service';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient, private login: LoginService) { }
  username = this.login.getUser().fullName;

  findByPatientName() {
    return this.http.get<any>(`${baseUrl}/api/v1/appointments/getpatientinfoby/` + this.username)
  }

  payBill(appointment: any) {
    let id = { "id": appointment.id }
    console.log(id)
    return this.http.post<any>(`${baseUrl}/api/v1/appointments/paybill`, id);
  }
}
