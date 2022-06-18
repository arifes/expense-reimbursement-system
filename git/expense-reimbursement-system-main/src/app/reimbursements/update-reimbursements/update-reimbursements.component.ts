import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Request } from 'src/app/request.model';
import { RequestsHttpService } from 'src/app/requests-http.service';

@Component({
  selector: 'update-reimbursements',
  templateUrl: './update-reimbursements.component.html',
  styleUrls: ['./update-reimbursements.component.css']
})
export class UpdateReimbursementsComponent implements OnInit {
  currentAllRequests: Request[];
  pendingRequests: Request[];
  resolvedRequests: Request[];

  updateRequest: Request = {
    requestId: 0,
    userId: 0,
    requestAmount: 0,
	requestDescription: '',
	requestStatus: '',
	requestImageURL: '',
	requestTime: '',
	resolvedTime: '',
  }


  constructor(private activatedRoute: ActivatedRoute,
              private requestHttpService: RequestsHttpService,
              private router: Router) { 
                this.currentAllRequests = [];
                this.pendingRequests = [];
                this.resolvedRequests = [];}

  ngOnInit(): void {
    let bidParam = this.activatedRoute.snapshot.paramMap.get('rid');
    console.log(bidParam);
    this.requestHttpService.getARequest(bidParam).subscribe((response)=>{
      this.updateRequest = response;
    })
    this.loadData();
    this.getRequestsByStatus(status);
  }

    changeStatus(status: any){
      this.updateRequest.requestStatus
    }

  

  updateRequestInfo(){
    this.requestHttpService.updateRequest(this.updateRequest).subscribe((response)=>{
      this.router.navigate(['view-Reimbursments'])
    })
  }
  loadData(){
    this.requestHttpService.getAllRequests().subscribe((response)=>{
      console.log(response);
      this.currentAllRequests = response;
    })
  }
  getRequestsByStatus(status: string){
    console.log(status);
    this.requestHttpService.getRequestsByStatus(status).subscribe((response)=>{ 
      this.pendingRequests = response;
    })

  }
  

getResolvedRequests(){
  this.resolvedRequests = this.currentAllRequests.filter(request => request.requestStatus != "pending");
}
Update(requestId: number){
  this.router.navigate(['update-reimbursements', requestId])
}
}




