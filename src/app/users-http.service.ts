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

  getAllEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl);
  }
}
