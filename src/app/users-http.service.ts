import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employees/employee.model';
import { User } from './users/user.model';
import { TitleStrategy } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UsersHttpService {

  baseUrl: string = "http://localhost:5555/api/users";
  router: any;
  usersHttpService: any;

updateProfile: Employee = {
    userId: 0,
    userFirstName: '',
    userLastName: '',
    userEmail: '',
    userRole: '',
    userPassword: ''
  }
  constructor(private http: HttpClient) { }

  getAllEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl);
  }
  validateUser(user: User): Observable<User>{
    return this.http.post<User>(this.baseUrl, user);
}
updateEmployeeProfile(){
  this.usersHttpService.updateProfile(this.updateProfile).subscribe(()=>{
    this.router.navigate(['update-profile']);
  })

}
}
