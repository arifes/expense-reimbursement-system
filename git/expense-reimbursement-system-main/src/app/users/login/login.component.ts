import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersHttpService } from 'src/app/users-http.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  useremail = 'youssef@revature.com'
  password = ''
  invalidLogin = false

  constructor(private router: Router,
    public loginservice:UsersHttpService ) { }

  ngOnInit() {
  }

  checkLogin() {
    if (this.loginservice.authenticate(this.useremail, this.password)
    ) {
      this.router.navigate([''])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }

}
