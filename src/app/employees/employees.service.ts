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

getAEmployeeProfile(userId:any): Employee{
  let sentProfile: Employee ={
    userId: 0,
    userFirstName: "",
    userLastName: "",
    userEmail: "",
    userRole: "",
    userPassword: ''
  }
  for (let i=0; i<this.allEmployees.length;i++){
    if (this.allEmployees[i].userId==userId){
      sentProfile=this.allEmployees[i];
    }
  }
  return sentProfile;
}
 updateProfile(sentProfile:Employee): void{
  for (let i=0;i<this.allEmployees.length;i++){
    if (this.allEmployees[i].userId==sentProfile.userId){
      this.allEmployees[i]=sentProfile;
    }
  }
 }
}
