import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersHttpService } from 'src/app/users-http.service';
import { AuthService } from '../auth.service';
import { User } from '../user.model';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  invalidMessage: string = "";

  user: User ={
    userId:0,
    userFirstName: '',
    userLastName: '',
    userEmail: '',
    userPassword: '',
    userRole: '',
  }

  constructor(private userHttpService: UsersHttpService,
    private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }
  
  loginValidation(){
    this.userHttpService.validateUser(this.user).subscribe((response)=>{
      console.log(response);
      if(response.userRole != "" ){
        //login success
        // send the respone to auth service and store the info in the session storage
        this.authService.storeUserInfo(response);
        // also set the isLoggedIn varibale of auth service to true
        this.authService.isLoggedIn = true;
        if(response.userRole == "manager"){
            //set the role to admin in auth service
            this.authService.role="manager";
            // route to view-http-book
            this.router.navigate(['reimbursements']);
        }else if(response.userRole == "employee"){
            //set the role to employee in auth service
            this.authService.role="employee";
            // route to display component
            this.router.navigate(['profile']);
        }
      }else{
        //login failed
        // stay back in this component and display
            // an error message on the the template
        this.invalidMessage = "Invalid Username/Password";
      }
    
    });
  }

}
