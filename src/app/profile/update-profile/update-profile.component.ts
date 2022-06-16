import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/employees/employee.model';
import { EmployeesService } from 'src/app/employees/employees.service';

@Component({
  selector: 'update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  currentAllEmployees: Employee[];

  constructor(private employeeService: EmployeesService) {
    this.currentAllEmployees = [];
  }

  ngOnInit(): void {
  }

}
