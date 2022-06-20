import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
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

  updateRequest: Request = {
    requestId: 0,
    userId: 0,
    requestAmount: 0,
	requestDescription: '',
	requestStatus: '',
	requestImageURL: '',
	
  

  }
 
   
   
    

  constructor(private activatedRoute: ActivatedRoute,
              private requestHttpService: RequestsHttpService,
              private router: Router) { 
                this.currentAllRequests = [];
                this.pendingRequests = [];
              
              
              }
                
  ngOnInit(): void {
   
    this.loadData();
    this.getPendingRequests();
  }

    changeStatus(status: any, request: Request){
      this.updateRequest.requestStatus = status
      console.log(status);
      console.log(this.updateRequest);
    }

  

  updateRequestInfo(updateRequest: Request){
    
    this.requestHttpService.updateRequest(this.updateRequest).subscribe((response)=>{
      console.log(this.updateRequest);
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
  getPendingRequests(){
    this.pendingRequests = this.currentAllRequests.filter(request => request.requestStatus == "pending");
  }


Update(requestId: any){
  this.requestHttpService.getARequest(requestId).subscribe((response)=>{
    this.updateRequest = response;
    console.log(this.updateRequest)
  
})
}
}




