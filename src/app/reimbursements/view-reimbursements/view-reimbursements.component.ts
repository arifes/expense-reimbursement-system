import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Request } from 'src/app/request.model';
import { RequestsHttpService } from 'src/app/requests-http.service';


@Component({
  selector: 'view-reimbursements',
  templateUrl: './view-reimbursements.component.html',
  styleUrls: ['./view-reimbursements.component.css']
})
export class ViewReimbursementsComponent implements OnInit {

  currentAllRequests: Request[];
  pendingRequests: Request[];
  resolvedRequests: Request[];

  constructor(private activatedRoute: ActivatedRoute,
    private requestsHttpService: RequestsHttpService,
              private router: Router ) {
  this.currentAllRequests = [];
  this.pendingRequests = [];
  this.resolvedRequests = [];
               }

  ngOnInit(): void {
    this.loadData();
    this.getRequestsByStatus(status);
    }

    loadData(){
    this.requestsHttpService.getAllRequests().subscribe((response)=>{
      console.log(response);
      this.currentAllRequests = response;
    })
  }
  getRequestsByStatus(status: string){
    console.log(status);
    this.requestsHttpService.getRequestsByStatus(status).subscribe((response)=>{ 
      this.pendingRequests = response;
    })

  }

getResolvedRequests(){
  this.resolvedRequests = this.currentAllRequests.filter(request => request.requestStatus != "pending");
}
goToUpdateRequest(requestId: number){
  this.router.navigate(['update-reimbursements', requestId])
}


    
  
}

