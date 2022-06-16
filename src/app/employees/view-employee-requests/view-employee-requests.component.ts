import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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

  constructor( private activatedRoute: ActivatedRoute,
    private requestsHttpService: RequestsHttpService,
                private router: Router) { 
  this.allRequests = [];
  this.currentRequestsByEmployee = [];
   }

  ngOnInit(): void {
    let bidParam = this.activatedRoute.snapshot.paramMap.get('uid');
    console.log(bidParam);
    this.requestsHttpService.getAllRequestsByEmployee(bidParam).subscribe(response =>{
      console.log(response);
      this.currentRequestsByEmployee = response
  
  })

}
}
