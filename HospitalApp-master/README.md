# HospitalApp
Our hospital patient interface is a web application that allows users to register, log in, and manage appointments, doctors, and patients. We built the backend of the application using Java, and the frontend using Angular, HTML, and CSS. The database we used is PostgreSQL, which stores user, appointment, doctor, and patient information securely.

To ensure the security of the application, we used Spring Security for authentication and authorization purposes. Users can register with a unique username, email ID, name, mobile number, age, and password. After registering, they can log in and select an appointment date, timing, doctor name, and disease. We automatically fetch the doctor's specialty based on the selected doctor name.

In the doctor's section, doctors can add a description of their checkup and charges for the treatment. This information is then sent to the admin for review. In the admin section, the admin can see a list of all doctors and patients. In the patient list, the admin can see who has completed their treatment, who is currently under treatment, and who has been discharged. The admin can also view and manage doctor and patient information.

At the end of the patient table, there is a pay bill column with a pay button. The pay button is disabled if there is no description of the treatment provided by the doctor or if the charges for the treatment have not been added. Additionally, the pay button is not visible for discharged patients.

We implemented validations throughout the application to ensure that only valid and accurate data is entered. The application validates user input in the registration form, login form, appointment selection, and other sections where applicable.

Overall, our hospital patient interface is a secure and user-friendly web application that allows users to manage appointments, doctors, and patients. We designed the application to be secure, reliable, and intuitive, and we hope that it will provide a valuable service to all who use it.

<h3>Demo run of The Project - </h3><hr>
<div align="center">
<h1 [align]="center">Home Page</h1><hr>
    <img src="screenshot/home1.png" width="80%"/>
    <img src="screenshot/home2.png" width="80%"/>
    <img src="screenshot/home3.png" width="80%"/><hr>
    <h1 [align]="center">Patient Registration Page Page</h1><hr>
    <img src="screenshot/registration1.png" width="80%"/><br>
    <img src="screenshot/registration2.png" width="80%"/><br>
    <img src="screenshot/registration3.png" width="80%"/><br><hr>
    <h1 [align]="center">Patient Login Page</h1><hr>
    <img src="screenshot/login.png" width="80%"/><hr>
    <h1 [align]="center">Book Appointment Page</h1><hr>
    <img src="screenshot/appbook.png" width="80%"/>
    <img src="screenshot/appbook2.png" width="80%"/><hr>
    <h1 [align]="center">Patient Dashboard</h1><hr>
    <img src="screenshot/udash.png" width="80%"/><hr>
    <h1 [align]="center">Patient Dashboard appointment Deatils</h1><hr>
    <img src="screenshot/patientdashAppDetails.png" width="80%"/>
    <img src="screenshot/patientDashAppDEtails2.png" width="80%"/><hr>
    <h1 [align]="center">Doctor Registration page</h1><hr>
    <img src="screenshot/dregister.png" width="80%"/>
    <img src="screenshot/dreg.png" width="80%"/><hr>
    <h1 [align]="center">Doctor Dashboard</h1><hr>
    <img src="screenshot/ddash.png" width="80%"/><hr>
    <h1 [align]="center">Appontment list for doctor</h1><hr>
    <img src="screenshot/aldoctor.png" width="80%"/><hr>
    <h1 [align]="center">Adding Prescription Page</h1><hr>
    <img src="screenshot/addprescp.png" width="80%"/><hr>
    <h1 [align]="center">Admin Dashboard</h1><hr>
    <img src="screenshot/admindash.png" width="80%"/><hr>
    <h1 [align]="center">Usre list for Admin</h1><hr>
    <img src="screenshot/aluser.png" width="80%"/>
    <img src="screenshot/aluser2.png" width="80%"/><hr>
    <h1 [align]="center">Doctor list for Admin</h1><hr>
    <img src="screenshot/doctor list.png" width="80%"/><hr>
    <h1 [align]="center">All Appointment List  for Admin</h1><hr>
    <img src="screenshot/aladmin.png" width="80%"/>
    <img src="screenshot/alad2.png" width="80%"/><hr>

    



    






    
</div>
