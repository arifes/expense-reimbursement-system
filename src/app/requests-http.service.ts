import { EventEmitter, Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, Subject, Subscription } from 'rxjs';
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
 getRequestsByStatus(status: string):Observable<Request[]>{
  return this.http.get<Request[]>(this.baseUrl+'/request_status/'+status);
 }
 updateRequest( updateRequest: Request): Observable<Request>{
    return this.http.post<Request>(this.baseUrl, updateRequest);
 }
 getARequest(requestId: any): Observable<Request>{
   return this.http.get<Request>(this.baseUrl+'/request_id/'+requestId);
 }
 addRequest(request: Request): Observable<Request>{
  return this.http.put<Request>(this.baseUrl, request);
}
}
