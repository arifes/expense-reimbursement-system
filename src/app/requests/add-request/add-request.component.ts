 import { Component, OnInit } from '@angular/core';
 import { Router } from '@angular/router';
 import { Request } from 'src/app/request.model';
 import { RequestsHttpService } from 'src/app/requests-http.service';

 

 @Component({
  selector: 'add-request',
   templateUrl: './add-request.component.html',
  styleUrls: ['./add-request.component.css']
 })
 export class AddRequestComponent implements OnInit {

  currentAllRequest: Request[];
  storeMessage: string = "";
   shouldDisplay: boolean = false;

     newRequest: Request = {
      userId: 0,
       requestAmount: 0,
       requestDescription: '',
      requestStatus: '',
       requestImageURL: '',
      requestId: 0
     };
   constructor(private requestsHttpService:RequestsHttpService,
               private router:Router) {this.currentAllRequest=[]}

   ngOnInit(): void {
   }
   loadData(){

   this.requestsHttpService.getAllRequests().subscribe(
       {
        next: (response) => {
                              console.log(response);
                              this.storeMessage = '';
                             this.currentAllRequest = response;
                          },
        error: (error)=> { 
          console.log(error.error.errorMessage);
          this.storeMessage = error.error.errorMessage;
        }
      });
  }
  addANewRequest(){
   this.requestsHttpService.addRequest(this.newRequest).subscribe((response)=>{
     console.log(response);
      
       this.loadData();

      
      this.newRequest = {
      userId: 0,
      requestAmount: 0,
      requestDescription: '',
	    requestStatus: '',
	    requestImageURL: '',
      requestId: 0
      };

 })
  }

}

