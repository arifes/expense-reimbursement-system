import { Component, OnInit } from '@angular/core';
import { RequestsHttpService } from '../requests-http.service';
import { AuthService } from '../users/auth.service';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService,
                private requestHttpService: RequestsHttpService) { }

  ngOnInit(): void {
  }

 
  hasLoggedIn(){
    return this.authService.isLoggedIn;
  }

  getRole(){
    return this.authService.role;
  }
}
