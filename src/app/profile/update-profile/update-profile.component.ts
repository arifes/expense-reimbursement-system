import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/employees/employee.model';
import { EmployeesService } from 'src/app/employees/employees.service';

@Component({
  selector: 'update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  updateProfile: Employee = {
    userId: 0,
    userFirstName: '',
    userLastName: '',
    userEmail: '',
    userRole: '',
    userPassword: ''
  }
  activatedRoute: any;
  constructor(private employeesService: EmployeesService ,private router: Router) { }

  ngOnInit(): void {

  let bidParam=this.activatedRoute.snapshot.paramMp.get('userId');
  console.log(bidParam);
  this.updateProfile=this.employeesService.getAEmployeeProfile(bidParam);
}
  updateEmployeeProfile(){
    this.employeesService.updateProfile(this.updateProfile)
    this.router.navigate(['update-profile']);
}

}
