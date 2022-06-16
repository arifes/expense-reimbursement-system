import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Request } from 'src/app/request.model';
import { RequestsHttpService } from 'src/app/requests-http.service';

@Component({
  selector: 'employeeRequests',
  templateUrl: './view-employee-requests.component.html',
  styleUrls: ['./view-employee-requests.component.css']
})
export class ViewEmployeeRequestsComponent implements OnInit {

  allRequests: Request[];
  currentRequestsByEmployee: Request[];

  constructor( private requestsHttpService: RequestsHttpService,
                private router: Router) { 
  this.allRequests = [];
  this.currentRequestsByEmployee = [];
   }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(){
    this.requestsHttpService.getAllRequests().subscribe((response)=>{
      console.log(response);
      this.allRequests = response;
    })
 };
getAllRequestsByEmployee(userId: number){
 this.requestsHttpService.getAllRequestsByEmployee(userId).subscribe(response =>{
  console.log(response);
  this.currentRequestsByEmployee = response
 })
}
}
