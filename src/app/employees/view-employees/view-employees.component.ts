import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeesService } from '../employees.service';

@Component({
  selector: 'view-employees',
  templateUrl: './view-employees.component.html',
  styleUrls: ['./view-employees.component.css']
})
export class ViewEmployeesComponent implements OnInit {

 // employeeService: EmployeesService;
  currentAllEmployees: Employee[];

  constructor(private employeeService: EmployeesService) { 
    this.currentAllEmployees = [];
  this.employeeService = new EmployeesService();
  }

  ngOnInit(): void {
    this.currentAllEmployees = this.employeeService.getAllEmployees();
  }

}
