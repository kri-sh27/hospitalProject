import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
// import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginData = {
    username: '',
    password: '',
  }


  constructor(private login: LoginService, private router: Router) { }

  ngOnInit(): void {
  }






  formSubmit() {
    console.log('Login Button clicked');

    if (this.loginData.username.trim() == '' || this.loginData.username == null) {
      Swal.fire('username is requird', 'error');
      return;
    }

    else if (this.loginData.password.trim() == '' || this.loginData.password == null) {
      Swal.fire('password is requird', 'error');
      return;
    }

    ///setting user in localstorage
    this.login.setUser(this.loginData)
    // console.log(this.login.getUser());


    //request to server to generate token

    this.login.generateToken(this.loginData).subscribe(
      (data: any) => {
        console.log("success");
        console.log(data);
        // console.log(this.loginData);

        //login...
        this.login.loginUser(data.token);
        this.login.getCurrentUser().subscribe(
          (user: any) => {
            this.login.setUser(user);
            // console.log(user)

            // redirect.. ADMIN=> admin dashboard
            // Normal=>normal dashboard
            if (this.login.getUserRole() == "ADMIN") {

              // window.location.href='/admin';
              this.router.navigate(['admin']);
              this.login.loginStatusSubject.next(true);
            } else if (this.login.getUserRole() == "NORMAL") {
              // window.location.href='/user-dashboard';
              this.router.navigate(['user-dashboard']);
              this.login.loginStatusSubject.next(true);
            } else if (this.login.getUserRole() == "DOCTOR") {
              this.router.navigate(['doctor-dashboard'])
              this.login.loginStatusSubject.next(true);
            }

            else {
              this.login.logout();

            }
          }
        );
      },
      (error: any) => {
        console.log("error");
        console.log(error);
      //  let m:string=String(error.status)
        Swal.fire('invalid credentials', 'error');

      }
    );
  }
}
