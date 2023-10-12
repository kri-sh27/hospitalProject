import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './healper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  //add user
  public addUser(user: any) {
    console.log(user);
    return this.http.post(`${baseUrl}/createuser`, user)
  }
  //add doctor
  public addDoctor(user: any) {
    console.log(user);
    return this.http.post(`${baseUrl}/addDoctor`, user)
  }


}
