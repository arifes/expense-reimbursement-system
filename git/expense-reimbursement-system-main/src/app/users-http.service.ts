import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

import { Employee } from './employees/employee.model';

@Injectable({
  providedIn: 'root'
})
export class UsersHttpService {

  baseUrl: string = "http://localhost:5555/api/users";

  constructor(private http: HttpClient) { }

  getUsers(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl);
  }
  getUser(userId:any):Observable<Employee>{
    return this.http.get<Employee>(this.baseUrl+'/'+userId);
  }
  editUser(sentRequest:Employee):Observable<Employee>{
    return this.http.put<Employee>(this.baseUrl,sentRequest);

  }
  authenticate(useremail: string, password: string) {
    if (useremail === "youssef@revature.com" && password === "password") {
      sessionStorage.setItem('username', useremail)
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('useremail')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('useremail')
  }

}
