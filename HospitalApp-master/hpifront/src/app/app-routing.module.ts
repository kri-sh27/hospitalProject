import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AdddoctorComponent } from './pages/admin/adddoctor/adddoctor.component';
import { AppointmentlistforadminComponent } from './pages/admin/appointmentlistforadmin/appointmentlistforadmin.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { DoctorlistComponent } from './pages/admin/doctorlist/doctorlist.component';
import { AddprescriptionComponent } from './pages/doctor/addprescription/addprescription.component';
import { AppointmentlistComponent } from './pages/doctor/appointmentlist/appointmentlist.component';
import { DoctorDashboardComponent } from './pages/doctor/doctor-dashboard/doctor-dashboard.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AppointmentComponent } from './pages/user/appointment/appointment.component';
import { ProfileComponent } from './pages/user/profile/profile.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AdminGuard } from './services/admin.guard';
import { DoctorGuard } from './services/doctor.guard';
import { NormalGuard } from './services/normal.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full',
  }, {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full',
  },
  {
    path: 'admin',
    component: DashboardComponent,
    pathMatch: 'full',
    canActivate: [AdminGuard],
  },
  {
    path: 'user-dashboard',
    component: UserDashboardComponent,
    pathMatch: 'full',
    canActivate: [NormalGuard],
  },
  {
    path: 'adddoctor',
    component: AdddoctorComponent,
    pathMatch: 'full',
    canActivate: [AdminGuard],

  },
  {
    path: 'doctorlist',
    component: DoctorlistComponent,
    pathMatch: 'full',
    canActivate: [AdminGuard],

  },
  {
    path: 'doctor-dashboard',
    component: DoctorDashboardComponent,
    pathMatch: 'full',
    canActivate: [DoctorGuard],
  },
  {
    path: 'appointmentlist',
    component: AppointmentlistComponent,
    pathMatch: 'full',
    canActivate: [DoctorGuard],
  },
  {
    path: 'appointment',
    component: AppointmentComponent,
    pathMatch: 'full',
    canActivate: [NormalGuard],
  },
  {
    path: 'addprescription',
    component: AddprescriptionComponent,
    pathMatch: 'full',
    canActivate: [DoctorGuard]
  },
  {
    path: 'appointmentlistforadmin',
    component: AppointmentlistforadminComponent,
    pathMatch: 'full',
    canActivate: [AdminGuard]
  },
  {
    path: 'profile',
    component: ProfileComponent,
    pathMatch: 'full',
    canActivate: [NormalGuard],
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
