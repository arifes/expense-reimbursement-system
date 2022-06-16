import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Request } from 'src/app/request.model';
import { RequestsHttpService } from 'src/app/requests-http.service';


@Component({
  selector: 'view-reimbursements',
  templateUrl: './view-reimbursements.component.html',
  styleUrls: ['./view-reimbursements.component.css']
})
export class ViewReimbursementsComponent implements OnInit {

  currentAllRequests: Request[];

  constructor(private requestsHttpService: RequestsHttpService,
              private router: Router ) {
  this.currentAllRequests = [];
               }

  ngOnInit(): void {
    this.loadData();
    }

    loadData(){
    this.requestsHttpService.getAllRequests().subscribe((response)=>{
      console.log(response);
      this.currentAllRequests = response;
    })
  }
}
