import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RequestsHttpService } from 'src/app/requests-http.service';
import { Request } from 'src/app/request.model';

@Component({
  selector: 'resolved-reimbursements',
  templateUrl: './resolved-reimbursements.component.html',
  styleUrls: ['./resolved-reimbursements.component.css']
})
export class ResolvedReimbursementsComponent implements OnInit {
  currentAllRequests: Request[];
  resolvedRequests: Request[];
  constructor(private activatedRoute: ActivatedRoute,
    private requestsHttpService: RequestsHttpService,
              private router: Router) {
                this.currentAllRequests = [];
                this.resolvedRequests = [];
               }

  ngOnInit(): void {
    this.loadData();
    this.getResolvedRequests();
  }

  loadData(){
    this.requestsHttpService.getAllRequests().subscribe((response)=>{
      console.log(response);
      this.currentAllRequests = response;
    })
  }

getResolvedRequests(){
  this.resolvedRequests = this.currentAllRequests.filter(request => request.requestStatus != "pending");
}
}
