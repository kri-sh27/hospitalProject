import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../healper';

@Injectable({
  providedIn: 'root'
})
export class GetappointmentbyidService {

  constructor(private http:HttpClient) { }

  getappointmentbyid(id:any) {
    console.log(id);
    console.log("srevice called");
    return this.http.get<any>(`${baseUrl}/api/v1/appointments/`+id)
  }
}
