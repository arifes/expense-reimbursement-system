import { Injectable } from '@angular/core';
import { Employee } from './employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  allEmployees: Employee [] = [
    {
    userId: 1,
    userFirstName: 'John', 
    userLastName: 'Smith' ,
    userEmail:   'johnsmith@gmail.com',
  }
  ];

  constructor() { }

  getAllEmployees(): Employee []{
    return this.allEmployees;
  }
}
