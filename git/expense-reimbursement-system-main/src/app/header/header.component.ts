import { Component, OnInit } from '@angular/core';
import { UsersHttpService } from '../users-http.service';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public loginService:UsersHttpService) { }

  ngOnInit(): void {
  }

}
