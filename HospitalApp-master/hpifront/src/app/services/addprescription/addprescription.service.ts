import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../healper';

@Injectable({
  providedIn: 'root'
})
export class AddprescriptionService {


  constructor(private http: HttpClient) { }

  public addprescription(addprescriptionandfees: any) {
    console.log(addprescriptionandfees);
    return this.http.post(`${baseUrl}/api/v1/appointments/addprescriptionandfees`, addprescriptionandfees)
  }
}
