import { Injectable } from '@angular/core';
import { Employee } from './employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  allEmployees: Employee [] = [
    {
    userId: 0,
    userFirstName: '', 
    userLastName: '' ,
    userEmail:   '',
    userPassword: '',
    userRole: '',
  }
  ];

  constructor() { }

  getAllEmployees(): Employee []{
    return this.allEmployees;
  }

 // getAllRequestsByEmployee(userId: number){
 //     return this.allRequestsByEmployee;
 // }
}
