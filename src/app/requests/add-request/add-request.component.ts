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
    newRequest: Request = {
      userId: 0,
      requestAmount: 0,
      requestDescription: '',
      requestStatus: '',
      requestImageURL: '',
      requestId: 0
    };
  constructor(private requestsHttpService:RequestsHttpService,
              private router:Router) { }

  ngOnInit(): void {
  }
  addANewRequest(){
   // this.requestsHttpService.addARequest(this.newRequest).subscribe((response)=>{
      //this response is not of much use
    //  console.log(response);
       // we need a fresh fetch of all books from the database
      //this.loadData();

      // clear the Add Form
      this.newRequest = {
      userId: 0,
      requestAmount: 0,
      requestDescription: '',
	    requestStatus: '',
	    requestImageURL: '',
      requestId: 0
      };

    //})
  }

}

