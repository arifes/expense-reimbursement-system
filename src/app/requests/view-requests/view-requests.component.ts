import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Request } from 'src/app/request.model';
import { RequestsHttpService } from 'src/app/requests-http.service';



@Component({
  selector: 'view-requests',
  templateUrl: './view-requests.component.html',
  styleUrls: ['./view-requests.component.css']
})
export class ViewRequestsComponent implements OnInit {

  employeeRequests: Request[];
  currentRequestsByEmployee: Request[];

  constructor(private activatedRoute: ActivatedRoute,
    private requestsHttpService: RequestsHttpService,
    private router: Router) { 

      this.employeeRequests = []
      this.currentRequestsByEmployee = [];
   }
    

   ngOnInit(): void {
    let bidParam = this.activatedRoute.snapshot.paramMap.get('uid');
    console.log(bidParam);
    this.requestsHttpService.getAllRequestsByEmployee(bidParam).subscribe((response: Request[]) =>{
      console.log(response);
      this.currentRequestsByEmployee = response
  
  })

}
}
