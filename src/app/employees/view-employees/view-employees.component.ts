import { Component, OnInit } from '@angular/core';
import { UsersHttpService } from 'src/app/users-http.service';
import { Employee } from '../employee.model';
import { Router } from '@angular/router';

@Component({
  selector: 'view-employees',
  templateUrl: './view-employees.component.html',
  styleUrls: ['./view-employees.component.css']
})
export class ViewEmployeesComponent implements OnInit {

 // employeeService: EmployeesService;
  currentAllEmployees: Employee[];
  

  constructor(private usersHttpService: UsersHttpService,
              private router: Router) { 
    this.currentAllEmployees = [];
  //this.employeeService = new EmployeesService();
  }

  ngOnInit(): void {
   this.loadData();
    }
    loadData(){
      this.usersHttpService.getAllEmployees().subscribe((response)=>{
        console.log(response);
        this.currentAllEmployees = response;
    })
  }

   viewEmployeeRequests(userId : any){
     console.log(userId);
     this.router.navigate(['employeeRequests',userId]);

   }

}
