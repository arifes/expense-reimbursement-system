import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
    this.authService.removeUserInfo();

    // also change the isLoggedIn to false in auth service
    this.authService.isLoggedIn = false;

    // also change the role in auth service to ""
    this.authService.role = "";

    // navigate to the login component
    this.router.navigate(['login']);
  }
  }


