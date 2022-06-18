import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersHttpService } from 'src/app/users-http.service';

@Component({
  selector: 'log-out',
  templateUrl: './log-out.component.html',
  styleUrls: ['./log-out.component.css']
})
export class LogOutComponent implements OnInit {

  constructor (private usersHttpService: UsersHttpService,
  private router: Router){

   }


 ngOnInit(): void {
  this.usersHttpService.logOut();
  this.router.navigate(['login'])

  }
}
