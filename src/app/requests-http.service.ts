import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Request } from './request.model';

@Injectable({
  providedIn: 'root'
})
export class RequestsHttpService {

  baseUrl: string = "http://localhost:5555/api/requests";

  constructor(private http: HttpClient) { }

  getAllRequests(): Observable<Request[]>{
    return this.http.get<Request[]>(this.baseUrl);
  }

  getAllRequestsByEmployee(userId: any): Observable<Request[]>{
    return this.http.get<Request[]>(this.baseUrl+'/'+userId);
 }
}
